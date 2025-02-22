package au.com.crazybean.mobilex.kurir.modules.creation

import androidx.fragment.app.Fragment
import au.com.crazybean.foundation.navigator.Arguments
import au.com.crazybean.mobilex.kurir.R
import au.com.crazybean.mobilex.kurir.modules.base.BaseActivity
import au.com.crazybean.mobilex.kurir.modules.base.FragmentBoard
import au.com.crazybean.mobilex.kurir.modules.base.Module
import au.com.crazybean.mobilex.kurir.modules.creation.desc.DescFragment
import au.com.crazybean.mobilex.kurir.modules.creation.receiver.ReceiverFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

private const val kDesc = "DESC"
private const val kRecv = "RECEIVER"

class CreationActivity : BaseActivity<CreationActor>(), CreationScene {
    private var fragmentBoard: FragmentBoard? = null

    override val actor: CreationActor? by inject {
        parametersOf(this)
    }

    override val layoutRes: Int
        get() = R.layout.activity_creation

    override fun showCreation() {
        fragmentBoard = FragmentBoard.Builder(this)
            .setCreator(object : FragmentBoard.Creator {
                override fun initiate(tag: String): Fragment? = when (tag) {
                    kDesc -> DescFragment()
                    kRecv -> ReceiverFragment()
                    else -> null
                }
            }).build()
        fragmentBoard?.add(R.id.fragment_placeholder,
            kDesc
        )
    }

    override fun process(arguments: Arguments) {
        super.process(arguments)
        when (arguments.module) {
            Module.Desc.ordinal -> fragmentBoard?.add(R.id.fragment_placeholder,
                kDesc
            )
            Module.Receiver.ordinal -> fragmentBoard?.replace(R.id.fragment_placeholder,
                kRecv, params = arguments.extras)
        }
    }
}