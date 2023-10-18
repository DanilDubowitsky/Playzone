package theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class PlayZoneColors(
    val primaryBackground: Color,
    val primaryAction: Color,
    val primaryTextColor: Color,
    val hintTextColor: Color,
    val highlightTextColor: Color,
    val secondaryTextColor: Color,
    val thirdTextColor: Color,
    val tagColor: Color,
    val tagTextColor: Color
)

val palette = PlayZoneColors(
    primaryBackground = Color(0xFF050B18),
    primaryAction = Color(0xFFF4D144),
    primaryTextColor = Color(0xFF050B18),
    hintTextColor = Color(0xFF696C75),
    highlightTextColor = Color(0xFFF4D144),
    secondaryTextColor = Color(0xFFFFFFFF),
    thirdTextColor = Color(0xFFEEF2FB),
    tagColor = Color(0x1844A9F4),
    tagTextColor = Color(0xFF44A9F4)
)

val LocalColorProvider = staticCompositionLocalOf<PlayZoneColors> {
    error("No default implementation")
}
