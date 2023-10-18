package admin.events

import admin.events.models.AdminEventsAction
import admin.events.models.AdminEventsEvent
import admin.events.models.AdminGamesViewState
import com.adeo.kviewmodel.BaseSharedViewModel

class AdminEventsViewModel :
    BaseSharedViewModel<AdminGamesViewState, AdminEventsAction, AdminEventsEvent>(
        AdminGamesViewState()
    ) {

    override fun obtainEvent(viewEvent: AdminEventsEvent) {

    }

}