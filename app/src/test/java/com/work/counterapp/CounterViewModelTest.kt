package com.work.counterapp

import com.work.counterapp.views.increment.IncrementButtonUiState
import com.work.counterapp.views.reset.ResetButtonUiState
import com.work.counterapp.views.text.TextUiState
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CounterViewModelTest {
    private lateinit var counterViewModel: CounterViewModel
    private lateinit var fakeRepository: FakeRepository

    @Before
    fun setUp() {
        fakeRepository = FakeRepository()
        counterViewModel = CounterViewModel(repository = fakeRepository)
    }

    @Test
    fun testInit() {
        var actual: UiState = counterViewModel.init()
        var expected: UiState = UiState.Initial(
            text = TextUiState.Initial,
            incrementButton = IncrementButtonUiState.Initial,
            resetButton = ResetButtonUiState.Initial
        )
        assertEquals(expected, actual)

        repeat(9) {
            actual = counterViewModel.increment()
            expected = UiState.Increment(
                text = TextUiState.Increment(it + 1),
                incrementButton = IncrementButtonUiState.Increment,
                resetButton = ResetButtonUiState.Increment
            )
            assertEquals(expected, actual)
        }

        actual = counterViewModel.increment()
        expected = UiState.Reset(
            text = TextUiState.Reset,
            incrementButton = IncrementButtonUiState.Reset,
            resetButton = ResetButtonUiState.Reset
        )
        assertEquals(expected, actual)

        actual = counterViewModel.reset()
        expected = UiState.Initial(
            text = TextUiState.Initial,
            incrementButton = IncrementButtonUiState.Initial,
            resetButton = ResetButtonUiState.Initial
        )
        assertEquals(expected, actual)
    }
}

private class FakeRepository() : Repository {

    private var value = 0
    override fun increment(): Int {
        value++
        return value
    }

    override fun isMax(): Boolean {
        return value == 10
    }

    override fun reset() {
        value = 0
    }
}