package com.ohno.mylauncher

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_apps_drawer.*

class AppsDrawerFragment: Fragment() {

    private val appsListAdapter by lazy { AppsDrawerAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_apps_drawer, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcv_apps.apply {
            adapter = appsListAdapter
        }

        getListApp()
    }

    private fun getListApp(){
        try {
            val packageManger = requireActivity().packageManager
            val tempListApp = ArrayList<AppInfo>()
            val intent = Intent(Intent.ACTION_MAIN, null)
            intent.addCategory(Intent.CATEGORY_LAUNCHER)

            val availableApps = packageManger.queryIntentActivities(intent, 0)
            for (app in availableApps) {
                val appInfo = AppInfo(app.loadLabel(packageManger), app.activityInfo.packageName, app.activityInfo.loadIcon(packageManger))
                tempListApp.add(appInfo)
            }
            appsListAdapter.setData(tempListApp)
        } catch (e: Exception) {
            Log.e("Error load app", e.message.toString())
        }
    }
}