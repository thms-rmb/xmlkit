package no.ramsen;

import net.sf.saxon.Configuration;
import net.sf.saxon.trans.CommandLineOptions;
import org.expath.httpclient.saxon.SendRequestFunction;

public class Transform extends net.sf.saxon.Transform {
    @Override
    protected void applyLocalOptions(CommandLineOptions options, Configuration config) {
        config.registerExtensionFunction(new SendRequestFunction());
        super.applyLocalOptions(options, config);
    }

    public static void main(String[] args) {
        Transform tr = new Transform();
        tr.doTransform(args, "");
    }
}
