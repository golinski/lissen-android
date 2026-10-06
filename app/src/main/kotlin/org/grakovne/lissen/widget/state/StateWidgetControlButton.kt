package org.grakovne.lissen.widget.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.glance.ColorFilter
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.LocalContext
import androidx.glance.action.Action
import androidx.glance.action.clickable
import androidx.glance.appwidget.cornerRadius
import androidx.glance.layout.Alignment
import androidx.glance.layout.Row
import androidx.glance.layout.size
import androidx.glance.unit.ColorProvider

@Composable
fun StateWidgetControlButton(
  icon: ImageVector,
  contentColor: ColorProvider,
  onClick: Action,
  modifier: GlanceModifier,
  size: Dp,
  contentDescription: String,
) {
  val density = Density(LocalContext.current.resources.displayMetrics.density)
  CompositionLocalProvider(LocalDensity provides density) {
    Row(
      modifier = modifier,
      verticalAlignment = Alignment.Vertical.CenterVertically,
      horizontalAlignment = Alignment.Horizontal.CenterHorizontally,
    ) {
      Image(
        provider = rememberWidgetIcon(icon, size),
        contentDescription = contentDescription,
        colorFilter = ColorFilter.tint(contentColor),
        modifier =
          GlanceModifier
            .size(size)
            .cornerRadius(16.dp)
            .clickable(onClick = onClick),
      )
    }
  }
}

// Glance accepts bitmaps rather than Compose vectors. Render at the displayed size
// so widget controls share the app's icons without duplicating their vector paths.
@Composable
private fun rememberWidgetIcon(
  icon: ImageVector,
  size: Dp,
): ImageProvider {
  val density = LocalDensity.current
  val painter = rememberVectorPainter(icon)
  val sizePx = with(density) { size.roundToPx().coerceAtLeast(1) }
  return remember(painter, sizePx) {
    val bitmap = ImageBitmap(sizePx, sizePx)
    val drawSize = Size(sizePx.toFloat(), sizePx.toFloat())
    CanvasDrawScope().draw(
      density = density,
      layoutDirection = LayoutDirection.Ltr,
      canvas = Canvas(bitmap),
      size = drawSize,
    ) {
      with(painter) { draw(drawSize) }
    }
    ImageProvider(bitmap.asAndroidBitmap())
  }
}
