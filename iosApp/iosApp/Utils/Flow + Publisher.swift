//
//  Flow + Publisher.swift
//  iosApp
//
//  Created by hackline on 13/10/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SharedSDK
import Combine

func statePublisher<T>(_ flow: KviewmodelWrappedStateFlow<T>) -> AnyPublisher<T, Never> {
    return Deferred<Publishers.HandleEvents<PassthroughSubject<T, Never>>> {
        let subject = PassthroughSubject<T, Never>()
        let closable = flow.watch { next in
            subject.send(next)
        }
        
        return subject.handleEvents(receiveCancel: {
            closable.close()
        })
    }.eraseToAnyPublisher()
}

func sharePublisher<T>(_ flow: KviewmodelWrappedSharedFlow<T>) -> AnyPublisher<T, Never> {
    return Deferred<Publishers.HandleEvents<PassthroughSubject<T, Never>>> {
        let subject = PassthroughSubject<T, Never>()
        let closable = flow.watch { next in
            if let next = next {
                subject.send(next)
            }
        }
        
        return subject.handleEvents(receiveCancel: {
            closable.close()
        })
    }.eraseToAnyPublisher()
}
