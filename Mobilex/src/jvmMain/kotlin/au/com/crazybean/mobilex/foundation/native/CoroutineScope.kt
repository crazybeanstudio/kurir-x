package au.com.crazybean.mobilex.foundation.native

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

actual val mainScope: CoroutineScope = MainScope()
