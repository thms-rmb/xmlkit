package no.ramsen;

import net.sf.saxon.Gizmo;
import net.sf.saxon.Query;
import net.sf.saxon.Transform;

import java.util.Arrays;
import java.util.function.Consumer;

public class App {
    public static void usage() {
        System.err.println("Usage: xmlkit (<transform> | <query> | <gizmo>) ...");
        System.exit(1);
    }

    public static void main( String[] args ) {
        if (args.length == 0) {
            usage(); return;
        }

        Consumer<String[]> command;
        switch (args[0]) {
            case "transform":
                command = Transform::main; break;
            case "query":
                command = Query::main; break;
            case "gizmo":
                command = Gizmo::main; break;
            default:
                usage(); return;
        }

        String[] arguments = Arrays.copyOfRange(args, 1, args.length);
        command.accept(arguments);
    }
}
