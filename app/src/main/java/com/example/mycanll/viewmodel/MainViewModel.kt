package com.example.mycanll.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.lang.Exception
import javax.script.ScriptEngineManager

/**
 * ViewModel handling calculator logic.
 * It stores the current expression and result as StateFlows so the UI recomposes on changes.
 */
class MainViewModel : ViewModel() {
    private val _expression = MutableStateFlow("")
    val expression: StateFlow<String> = _expression

    private val _result = MutableStateFlow("")
    val result: StateFlow<String> = _result

    // Simple JavaScript engine for evaluating arithmetic expressions.
    private val engine = ScriptEngineManager().getEngineByName("js")

    /**
     * Called when a calculator button is pressed.
     */
    fun onButtonPress(label: String) {
        when (label) {
            "C" -> {
                _expression.value = ""
                _result.value = ""
            }
            "=" -> evaluateExpression()
            else -> {
                // Append the pressed button to the expression string.
                _expression.value += label
            }
        }
    }

    /**
     * Evaluates the current expression using the JavaScript engine.
     * If evaluation fails, shows "Error".
     */
    private fun evaluateExpression() {
        try {
            val evalResult = engine.eval(_expression.value)
            _result.value = evalResult?.toString() ?: ""
        } catch (e: Exception) {
            _result.value = "Error"
        }
    }
}
