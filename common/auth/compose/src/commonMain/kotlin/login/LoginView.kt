package login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import login.models.LoginEvent
import login.models.LoginViewState
import theme.Theme
import widgets.CommonTextField

@Composable
fun LoginView(state: LoginViewState, eventHandler: (LoginEvent) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Login Now",
            color = Theme.colors.thirdTextColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 36.dp)
        )

        Text(
            text = "Welcome back to PlayZone! Enter your email addres and your password to enjoy the latest features of PlayZone",
            modifier = Modifier
                .padding(top = 15.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 14.sp,
            color = Theme.colors.hintTextColor,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(50.dp))

        CommonTextField(
            text = state.email,
            onValueChanged = {
                eventHandler(LoginEvent.EmailChanged(it))
            },
            hint = "Your login",
            enabled = !state.isSending
        )

        Spacer(modifier = Modifier.height(24.dp))

        CommonTextField(
            text = state.password, onValueChanged = {
                eventHandler.invoke(LoginEvent.PasswordChanged(it))
            },
            hint = "Password",
            isSecure = state.passwordHidden,
            enabled = !state.isSending,
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable {
                        eventHandler(LoginEvent.PasswordShowClick)
                    },
                    imageVector = if (state.passwordHidden) Icons.Outlined.Clear
                    else Icons.Outlined.Lock,
                    contentDescription = null,
                    tint = Theme.colors.hintTextColor,
                )
            }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Forgot Password",
                color = Theme.colors.primaryAction,
                fontSize = 12.sp,
                modifier = Modifier.clickable {
                    eventHandler(LoginEvent.ForgotClick)
                })
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Theme.colors.primaryAction
            ),
            enabled = !state.isSending,
            shape = RoundedCornerShape(10.dp),
            onClick = {
                eventHandler(LoginEvent.LoginClick)
            }) {
            Text(
                text = "Login Now",
                color = Theme.colors.primaryTextColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}