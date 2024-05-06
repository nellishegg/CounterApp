package com.work.counterapp

import com.work.counterapp.views.IntCache

interface Repository {

    fun increment(): Int
    fun isMax(): Boolean
    fun reset()

    class Base(
        private var currentTimesClicked: IntCache
    ) : Repository {

        override fun increment(): Int {
            val currentTimes = 0
            currentTimesClicked.save(currentTimes + 1)
            return currentTimes + 1
        }

        override fun isMax(): Boolean {
            return currentTimesClicked.read() == 5
        }

        override fun reset() {
            currentTimesClicked.save(0)
        }
    }
}
