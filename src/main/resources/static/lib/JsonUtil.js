
/**start将对象转换成字符串****************************************************************/
function json2str(it, prettyPrint) {
    return stringify(it, function(key, value) {
        if (value) {
            var tf = value.__json__ || value.json;
            if (typeof tf == "function") {
                return tf.call(value);
            }
        }
        return value;
    }, prettyPrint && this.toJsonIndentStr)
}

function stringify(value, replacer, spacer) {

    var undef;
    if (typeof replacer == "string") {
        spacer = replacer;
        replacer = null;
    }

    function stringify(it, indent, key) {
        if (replacer) {
            it = replacer(key, it);
        }
        var val, objtype = typeof it;
        if (objtype == "number") {
            return isFinite(it) ? it + "" : "null";
        }
        if (objtype == "boolean") {
            return it + "";
        }
        if (it === null) {
            return "null";
        }
        if (typeof it == "string") {
            return escapeString(it);
        }
        if (objtype == "function" || objtype == "undefined") {
            return undef;
        }

        if (typeof it.toJSON == "function") {
            return stringify(it.toJSON(key), indent, key);
        }
        if (it instanceof Date) {
            return '"{FullYear}-{Month+}-{Date}T{Hours}:{Minutes}:{Seconds}Z"'.replace(/\{(\w+)(\+)?\}/g, function(t, prop, plus) {
                var num = it["getUTC" + prop]() + (plus ? 1 : 0);
                return num < 10 ? "0" + num : num;
            });
        }
        if (it.valueOf() !== it) {

            return stringify(it.valueOf(), indent, key);
        }
        var nextIndent = spacer ? (indent + spacer) : "";

        var sep = spacer ? " " : "";
        var newLine = spacer ? "\n" : "";

        if (it instanceof Array) {
            var itl = it.length,
                res = [];
            for (key = 0; key < itl; key++) {
                var obj = it[key];
                val = stringify(obj, nextIndent, key);
                if (typeof val != "string") {
                    val = "null";
                }
                res.push(newLine + nextIndent + val);
            }
            return "[" + res.join(",") + newLine + indent + "]";
        }

        var output = [];
        for (key in it) {
            var keyStr;
            if (typeof key == "number") {
                keyStr = '"' + key + '"';
            } else if (typeof key == "string") {
                keyStr = escapeString(key);
            } else {

                continue;
            }
            val = stringify(it[key], nextIndent, key);
            if (typeof val != "string") {

                continue;
            }

            output.push(newLine + nextIndent + keyStr + ":" + sep + val);
        }
        return "{" + output.join(",") + newLine + indent + "}";
    }
    return stringify(value, "", "");

};

function escapeString( /*String*/ str) {

    return ('"' + str.replace(/(["\\])/g, '\\$1') + '"').
    replace(/[\f]/g, "\\f").replace(/[\b]/g, "\\b").replace(/[\n]/g, "\\n").
    replace(/[\t]/g, "\\t").replace(/[\r]/g, "\\r");
}
/**end将对象转换成字符串****************************************************************/

