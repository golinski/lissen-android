package org.grakovne.lissen.playback

import androidx.annotation.DrawableRes
import androidx.media3.session.R

internal object SeekButtonIcons {
  @DrawableRes
  fun back(seconds: Int?) =
    when (seconds) {
      5 -> R.drawable.media3_icon_skip_back_5
      10 -> R.drawable.media3_icon_skip_back_10
      15 -> R.drawable.media3_icon_skip_back_15
      30 -> R.drawable.media3_icon_skip_back_30
      else -> R.drawable.media3_icon_skip_back
    }

  @DrawableRes
  fun forward(seconds: Int?) =
    when (seconds) {
      5 -> R.drawable.media3_icon_skip_forward_5
      10 -> R.drawable.media3_icon_skip_forward_10
      15 -> R.drawable.media3_icon_skip_forward_15
      30 -> R.drawable.media3_icon_skip_forward_30
      else -> R.drawable.media3_icon_skip_forward
    }
}
