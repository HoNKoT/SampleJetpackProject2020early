package jp.chau2chaun2.honkot.samplejetpackproject2020.manager

import jp.chau2chaun2.honkot.samplejetpackproject2020.db.Repo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LegacyManager @Inject constructor(
    private val repo: Repo
)
