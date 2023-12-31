package home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import home.models.HomeEvent
import home.models.HomeViewState
import theme.Theme

@Composable
fun HomeView(viewState: HomeViewState, eventHandler: (HomeEvent) -> Unit) {
    Row(modifier = Modifier
        .clickable {
            eventHandler(HomeEvent.UserProfileClicked)
        }
        .padding(start = 24.dp, end = 24.dp, top = 24.dp)) {
//        AsyncImage(
//            modifier = Modifier
//                .clip(RoundedCornerShape(28.dp))
//                .size(56.dp),
//            model = viewState.avatarUrl,
//            contentDescription = "User Avatar",
//            contentScale = ContentScale.FillBounds
//        )

        Column(modifier = Modifier.padding(start = 20.dp)) {
            Text(
                text = viewState.status,
                color = Theme.colors.secondaryTextColor.copy(alpha = 0.5f),
                fontSize = 12.sp
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = viewState.userName,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Theme.colors.secondaryTextColor
            )
        }
    }
}
