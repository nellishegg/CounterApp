package com.work.counterapp

import com.work.counterapp.views.IntCache

interface Repository {

    fun increment(): Int
    fun isMax(): Boolean
    fun reset()

    class Base(
        private val currentTimesClicked: IntCache,
        private val max: Int = 10
    ) : Repository {

        override fun increment(): Int {
            val currentTimes = currentTimesClicked.read()
            currentTimesClicked.save(currentTimes + 1)
            return currentTimes + 1
        }

        override fun isMax(): Boolean {
            return currentTimesClicked.read() == max
        }

        override fun reset() {
            currentTimesClicked.save(0)
        }
    }
}
