package com.ballisticapps.collatzConjectureVisualizer.naviagation.components

import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@NavGraph
annotation class CollatzCalculatorNavGraph(
    val start: Boolean = false
)