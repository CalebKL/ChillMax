package com.example.chillmax.util

enum class Action {
    ADD,
    DELETE,
    DELETE_ALL,
    UNDO,
    NO_ACTION
}

fun String?.toAction():Action{
    return when{
        this == "ADD" ->{
            Action.ADD
        }
        this =="DELETE"->{
            Action.DELETE
        }
        this == "DELETE_ALL"->{
            Action.DELETE_ALL
        }
        this == "UNDO"->{
            Action.UNDO
        }
        else ->{
            Action.NO_ACTION
        }
    }
}