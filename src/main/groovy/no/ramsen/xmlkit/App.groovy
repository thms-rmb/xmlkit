package no.ramsen.xmlkit

import net.sf.saxon.Gizmo
import net.sf.saxon.Query
import net.sf.saxon.Transform

class App {
    static void main(String[] args) {
        def arguments = args.toList()

        def program

        if (!arguments) {
            program = "transform"
        } else {
            program = arguments.remove(0)
        }

        def programs = [
                "gizmo": Gizmo,
                "transform": Transform,
                "query": Query
        ]

        programs[program].main(arguments.toArray(new String[0]))
    }
}
