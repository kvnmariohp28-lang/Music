/*
 * Copyright (C) 2026 Music
 *
 * SPDX-License-Identifier: GPL-3.0
 */

package com.dd3boh.outertune.lyrics

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.dd3boh.outertune.utils.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.json.JSONArray
import org.json.JSONObject

/** A private lyric and listening moment kept on this device. */
data class LyricEcho(
    val songId: String,
    val title: String,
    val artist: String,
    val line: String,
    val note: String,
    val positionMs: Long,
    val savedAt: Long,
)

/** Small local collection of lyric moments; it needs no account or database migration. */
object LyricsEcos {
    private val key = stringPreferencesKey("musicLyricsEcos")
    private const val LIMIT = 100

    fun observe(context: Context): Flow<List<LyricEcho>> =
        context.dataStore.data.map { parse(it[key]) }

    suspend fun save(context: Context, echo: LyricEcho) {
        context.dataStore.edit { preferences ->
            val old = parse(preferences[key])
            val distinct = old.filterNot {
                it.songId == echo.songId && it.positionMs == echo.positionMs && it.line == echo.line
            }
            preferences[key] = encode((listOf(echo) + distinct).take(LIMIT))
        }
    }

    private fun parse(raw: String?): List<LyricEcho> {
        if (raw.isNullOrBlank()) return emptyList()
        return runCatching {
            val array = JSONArray(raw)
            (0 until array.length()).map { index ->
                val item = array.getJSONObject(index)
                LyricEcho(
                    songId = item.optString("songId"),
                    title = item.optString("title"),
                    artist = item.optString("artist"),
                    line = item.optString("line"),
                    note = item.optString("note"),
                    positionMs = item.optLong("positionMs"),
                    savedAt = item.optLong("savedAt"),
                )
            }
        }.getOrDefault(emptyList())
    }

    private fun encode(echoes: List<LyricEcho>): String = JSONArray().apply {
        echoes.forEach { echo ->
            put(
                JSONObject()
                    .put("songId", echo.songId)
                    .put("title", echo.title)
                    .put("artist", echo.artist)
                    .put("line", echo.line)
                    .put("note", echo.note)
                    .put("positionMs", echo.positionMs)
                    .put("savedAt", echo.savedAt)
            )
        }
    }.toString()
}
