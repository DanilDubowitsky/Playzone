import setup.setupThemedNavigation
import javax.swing.JFrame
import javax.swing.SwingUtilities

fun main() = SwingUtilities.invokeLater {
    initKoin(PlatformConfiguration())

    JFrame().setupThemedNavigation()
}
