package no.ramsen;

import net.sf.saxon.Configuration;
import net.sf.saxon.trans.CommandLineOptions;
import org.expath.httpclient.saxon.SendRequestFunction;

public class Query extends net.sf.saxon.Query {
    @Override
    protected void applyLocalOptions(CommandLineOptions options, Configuration config) {
        config.registerExtensionFunction(new SendRequestFunction());
        super.applyLocalOptions(options, config);
    }

    public static void main(String[] args) {
        Query q = new Query();
        q.doQuery(args, "");
    }
}
