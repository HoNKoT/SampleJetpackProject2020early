package jp.chau2chaun2.honkot.samplejetpackproject2020.db

import android.content.Context
import jp.chau2chaun2.honkot.samplejetpackproject2020.db.Repo

class SampleRepo(private val context: Context): Repo {
    override fun getName(): String {
        return "$context"
    }
}