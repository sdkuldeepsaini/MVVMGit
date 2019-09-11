package com.dmi.topgit.model

/**
 * Created by Kuldeep Saini on 11-09-2019.
 */
data class GitModel(
    var username: String,
    var name: String,
    var type: String,
    var url: String,
    var avatar: String,
    var repo: Repo
) {
    data class Repo(
        var name: String,
        var description: String,
        var url: String
    )
}