package com.android.developer.exstore.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * @param onSend is action send trough and this need [imeActionType] set to [ImeAction.Send]
 * @param onDone is action done trough and this need [imeActionType] set to [ImeAction.Done]
 **/

@Composable
fun DefaultTextField(
    modifier: Modifier = Modifier,
    text: String,
    colorBorder: Color,
    label: @Composable (() -> Unit)? = null,
    onSend: (() -> Unit)? = null,
    onDone: (() -> Unit)? = null,
    hint: String,
    maxLength: Int = 200,
    error: String = "",
    style: TextStyle = TextStyle(
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 18.sp
    ),
    needFocus: Boolean = true,
    readOnly: Boolean = false,
    roundedSize: Int = 30,
    shape: Shape = RoundedCornerShape(roundedSize),
    focusManager: FocusManager = LocalFocusManager.current,
    imeActionType: ImeAction = ImeAction.Next,
    keyboardController: SoftwareKeyboardController? = null,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    isPasswordVisible: Boolean = false,
    onValueChange: (String) -> Unit,
    isFocus: (Boolean) -> Unit,
    useAllCostumeModifier: Boolean = false,
    focusRequester: FocusRequester = FocusRequester(),
) {
    val newModifier =
        if (useAllCostumeModifier) modifier else Modifier
            .fillMaxWidth()
            .then(modifier)

    Column(
        modifier = newModifier
    ) {
        TextField(
            value = text,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            enabled = needFocus,
            readOnly = readOnly,
            label = label,
            maxLines = maxLines,
            isError = error != "",
            keyboardActions = KeyboardActions(
                onSend = {
                    keyboardController?.hide()
                    onSend?.invoke()
                },
                onDone = {
                    onDone?.invoke()
                },
                onNext = {
                    focusManager.moveFocus(focusDirection = FocusDirection.Next)
                }
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = imeActionType,
                keyboardType = keyboardType,
            ),
            visualTransformation = if (!isPasswordVisible && isPasswordToggleDisplayed) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            singleLine = singleLine,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            textStyle = style,
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colorScheme.onBackground,
                errorCursorColor = MaterialTheme.colorScheme.errorContainer,
                containerColor = backgroundColor,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent {
                    isFocus(it.isFocused)
                }
                .semantics {
                    testTag = TagsTextField.STANDARD_TEXT_FIELD
                }
                .border(width = 2.dp, color = colorBorder, shape = shape)
                .focusRequester(focusRequester = focusRequester),
            shape = shape,
            placeholder = {
                Text(
                    text = hint,
                    style = TextStyle(
                        textIndent = TextIndent(firstLine = 1.sp),
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
            },
        )
        if (error.isNotEmpty()) {
            Text(
                text = error,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}