package com.kuloglu.hungry.core

import com.kuloglu.hungry.App
import com.kuloglu.hungry.db.AppDatabase
import com.kuloglu.hungry.db.entities.User
import org.jetbrains.anko.doAsync
import javax.inject.Inject

class DummyUsers(val app: App) {
    @Inject
    lateinit var db : AppDatabase
    private val userList : ArrayList<User> = ArrayList()
    init {
        app.component.inject(this)
        userList.add(getUser("Mustafa", "Yeşil", "myesil", "Esentepe mah. 3705 cad. no:155 kat:4 kapı no:8 Bağcılar İstanbul",
                "myesil@gmail.com", "+905435556677", "1497316730643-415fac54a2af"))

        userList.add(getUser("Osman", "Yeşil", "oyesil", "Esentepe mah. 3705 cad. no:155 kat:4 kapı no:8 Bağcılar İstanbul",
                "oyesil@gmail.com", "+905435987894", "1518806118471-f28b20a1d79d"))

        userList.add(getUser("Çağla", "Çetinoğlu", "ccet", "Keçeciler mah. balipaşa cad. no:35 kat:2 kapı no:4  Fatih İstanbul",
                "ccet@gmail.com", "+905235456537", "1474552226712-ac0f0961a954"))

        userList.add(getUser("Mark", "Zuk", "zukung", "Marriott mah. 305 cad. no:147 kat:4 kapı no:8  NewYork NewYork",
                "zukung@gmail.com", "+115422556677", "1529665253569-6d01c0eaf7b6"))

        userList.add(getUser("Ali İhsan", "Ural", "auu", "Konaklar mah. Salı Pazarı cad. Zooloji sok. no:1 kat:0 kapı no:1 Beşiktaş İstanbul",
                "auu@gmail.com", "+905432548725", "1467400492058-1aad44d4bcd6"))

        userList.add(getUser("Ekrem", "Yeşil", "myesil", "Esentepe mah. 3705 cad. no:155 kat:4 kapı no:8 Bağcılar İstanbul",
                "myesil@gmail.com", "+905435556677", "1505415918826-47f4e4ed470b"))

        userList.add(getUser("Mehmet", "Yeşil", "oyesil", "Esentepe mah. 3705 cad. no:155 kat:4 kapı no:8 Bağcılar İstanbul",
                "oyesil@gmail.com", "+905435987894", "1470816692915-9bd859f41421"))

        userList.add(getUser("Elif", "Çetinoğlu", "ccet", "Keçeciler mah. balipaşa cad. no:35 kat:2 kapı no:4  Fatih İstanbul",
                "ccet@gmail.com", "+905235456537", "1470441623172-c47235e287ee"))

        userList.add(getUser("John", "Zuk", "zukung", "Marriott mah. 305 cad. no:147 kat:4 kapı no:8  NewYork NewYork",
                "zukung@gmail.com", "+115422556677", "1453365180904-3312e935e12b"))

        userList.add(getUser("Kemal", "Ural", "auu", "Konaklar mah. Salı Pazarı cad. Zooloji sok. no:1 kat:0 kapı no:1 Beşiktaş İstanbul",
                "auu@gmail.com", "+905432548725", "1495347353326-f1e32ba8e136"))
    }
    private fun getUser(pName :String, pSurname :String, pUserName :String, pAddress :String, pEmail :String, pPhoneNumber :String, pPhotoUrl : String) :User{
        val user = User()
        user.apply {
            name = pName
            surname = pSurname
            userName =pUserName
            address = pAddress
            eMail = pEmail
            phoneNumber = pPhoneNumber
            photoUrl = pPhotoUrl
        }
        return user
    }

    fun putDummyUserToDb(){
    doAsync {
    db.userDao().insertUsers(userList)

    }
    }

}