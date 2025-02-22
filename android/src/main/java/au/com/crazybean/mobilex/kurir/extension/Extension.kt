package au.com.crazybean.mobilex.kurir.extension

import android.content.Intent
import android.os.Bundle
import au.com.crazybean.mobilex.foundation.saw.Wrapper
import org.koin.core.qualifier.StringQualifier

val Intent.params: Map<String, Any?>?
    get() = extras?.params

val Bundle.params: Map<String, Any?>?
    get() = keySet().map {
        it to get(it)
    }.toMap()

inline fun <reified WORKER: Wrapper> qualifier() = StringQualifier(WORKER::class.java.name)