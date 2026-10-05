package org.grakovne.lissen.ui.theme

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RippleConfiguration
import androidx.compose.material3.RippleDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import org.grakovne.lissen.common.ColorScheme

@Composable
fun TvTheme(
  colorSchemePreference: ColorScheme,
  materialYouEnabled: Boolean,
  content: @Composable () -> Unit,
) {
  LissenTheme(colorSchemePreference, materialYouEnabled) {
    val defaultAlpha = RippleDefaults.RippleAlpha
    CompositionLocalProvider(
      LocalTvFocusEnabled provides true,
      LocalRippleConfiguration provides
        RippleConfiguration(
          color = MaterialTheme.colorScheme.primary,
          rippleAlpha =
            RippleAlpha(
              draggedAlpha = defaultAlpha.draggedAlpha,
              focusedAlpha = 0.4f,
              hoveredAlpha = defaultAlpha.hoveredAlpha,
              pressedAlpha = defaultAlpha.pressedAlpha,
            ),
        ),
    ) {
      content()
    }
  }
}
