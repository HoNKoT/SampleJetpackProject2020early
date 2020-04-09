package jp.chau2chaun2.honkot.samplejetpackproject2020.db

import android.content.Context

class SampleRepo(
    private val context: Context
): Repo {
    private var count: Int = 0

    override fun getName(): String {
        return "$context"
    }

    override fun getCount(): Int {
        return count
    }

    override fun countUp() {
        count++
    }
}
