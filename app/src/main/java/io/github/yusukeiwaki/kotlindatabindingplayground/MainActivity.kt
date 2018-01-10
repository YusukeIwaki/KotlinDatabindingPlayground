package io.github.yusukeiwaki.kotlindatabindingplayground

import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import io.github.yusukeiwaki.kotlindatabindingplayground.databinding.ActivityMainBinding
import io.realm.Realm
import io.realm.Sort

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnAddUser.setOnClickListener { _ ->
            insertUser(binding.editorUsername.text.toString())
        }
        updateView()
    }

    private fun insertUser(name: String) {
        Realm.getDefaultInstance().use { realm ->
            realm.executeTransaction {
                it.createObject(User::class.java, System.currentTimeMillis()).let { user ->
                    user.name = name
                }
            }
        }
        updateView()
    }

    private fun updateView() {
        Realm.getDefaultInstance().use { realm ->
            realm.where(User::class.java).sort("id", Sort.DESCENDING).findFirst()?.let { user ->
                binding.lastUser = realm.copyFromRealm(user)
            }
        }
    }
}
