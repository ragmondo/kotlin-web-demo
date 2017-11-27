/**
 * Here's an example of a very basic state. As you can see, there is nothing required beyond implementing one of the
 * Corda State interfaces. We start with the most basic type - the Contract State. This requires that you implement
 * the [participants] get function. For this, we're just going to return an empty list.
 */

package education

import net.corda.core.contracts.ContractState
import net.corda.core.identity.AbstractParty

data class IOUState(val data: String = "data"): ContractState {
    override val participants: List<AbstractParty> get() = listOf() // Don't worry about this for now
}

fun main(args: Array<String>) {
    val myFirstState = IOUState("This is where you would put data in relevant to this instance of a state.")
    println(myFirstState) // Would be a waste just to destroy it straight away...
}

/**
 * So - what's happening here ?
 * You've created a Corda "Privately Shared Fact" - or in Corda terms, a "state".
 * There are the building blocks for Corda. Once one party has created a transaction (more on those shortly)
 * that includes one or more states, it will then send this transaction around the
 * network to other parties who will then agree that this reflects their view of the world as well.
 *
 * In this example code, it hasn't gone anywhere, but as you can see it's just like any plain class.
 * You can add some functions to it, more instance variables, references to other classes, collections etc etc etc.
 * The only restriction on what you can put in a Corda State class is that it must be able to serialize which is the
 * process used in order to send classes over the network - but we'll cover that issue later.
 */
