package org.grakovne.lissen.ui.theme

import androidx.compose.foundation.Indication
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf

internal val LocalTvFocusEnabled = compositionLocalOf { false }

/** Used by controls that intentionally suppress the normal touch ripple. */
@Composable
fun tvFocusIndication(): Indication? = if (LocalTvFocusEnabled.current) ripple() else null
