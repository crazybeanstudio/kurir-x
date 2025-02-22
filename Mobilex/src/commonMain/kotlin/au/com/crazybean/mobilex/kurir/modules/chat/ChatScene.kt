package au.com.crazybean.mobilex.kurir.modules.chat

import au.com.crazybean.mobilex.kurir.data.model.Message
import au.com.crazybean.mobilex.kurir.modules.base.Scene

interface ChatScene : Scene {
    fun showName(myEmail: String, name: String, initial: String)
    fun showMessages(messages: List<Message>)
    fun showMore(messages: List<Message>)
    fun clearText()
    fun showEmpty()
}