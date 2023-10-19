package widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import theme.Theme

@Composable
fun CommonTextField(
    text: String,
    onValueChanged: (String) -> Unit,
    hint: String,
    enabled: Boolean = true,
    isSecure: Boolean = false,
    trailingIcon: @Composable () -> Unit = {}
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        value = text,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFF1F2430),
            textColor = Theme.colors.secondaryTextColor,
            cursorColor = Theme.colors.highlightTextColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(10.dp),
        visualTransformation = if (isSecure) PasswordVisualTransformation()
        else VisualTransformation.None,
        onValueChange = onValueChanged,
        enabled = enabled,
        trailingIcon = trailingIcon,
        placeholder = {
            Text(text = hint, color = Theme.colors.hintTextColor)
        })
}
