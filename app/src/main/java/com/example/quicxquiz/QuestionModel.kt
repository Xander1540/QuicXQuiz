package com.example.quicxquiz

class QuestionModel{
    var question:String?=null
    var a:String?=null
    var b:String?=null
    var c:String?=null
    var d:String?=null
    var ans:String?=null

    constructor()
    constructor(question: String?, a: String?, b: String?, c: String?, d: String?, ans: String?) {
        this.question = question
        this.a = a
        this.b = b
        this.c = c
        this.d = d
        this.ans = ans
    }
}