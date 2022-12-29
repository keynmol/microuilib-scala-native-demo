//> using platform "scala-native"
//> using resourceDir "resources"

import microuilib.types.*
import microuilib.functions.*
import scala.scalanative.unsafe.*

@main def hello =
  Zone { implicit z =>
    val ctx = alloc[mu_Context](1)
    mu_init(ctx)
    (!ctx).text_width = CFuncPtr3.fromScalaFunction { (_, _, _) => 0 }
    (!ctx).text_height = CFuncPtr1.fromScalaFunction { _ => 0 }
    mu_begin(ctx)
    if (
      mu_begin_window_ex(ctx, c"My Window", mu_rect(10, 10, 300, 400), 0) != 0
    ) {
      mu_end_window(ctx);
    }
  }
