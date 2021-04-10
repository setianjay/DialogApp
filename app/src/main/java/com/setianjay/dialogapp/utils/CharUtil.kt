package com.setianjay.dialogapp.utils

class CharUtil {
    companion object{
         fun dropLastChar(str: String,character: Char): String {
             var result = ""
            if(str.isNotEmpty() && str[str.length - 1] == character){
                 result = str.substring(0,str.length - 1)
            }
                return result
        }
    }
}