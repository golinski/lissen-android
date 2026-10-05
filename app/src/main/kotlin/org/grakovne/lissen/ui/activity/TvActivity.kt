package org.grakovne.lissen.ui.activity

import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import org.grakovne.lissen.common.ColorScheme
import org.grakovne.lissen.ui.theme.TvTheme

@AndroidEntryPoint
class TvActivity : BaseAppActivity() {
  @Composable
  override fun AppTheme(
    colorScheme: ColorScheme,
    materialYou: Boolean,
    content: @Composable () -> Unit,
  ) {
    TvTheme(colorScheme, materialYou, content)
  }
}
