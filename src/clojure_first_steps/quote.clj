(ns clojure-first-steps.quote)

;There may be some confusion here from the different usages of the term "symbol" in Common Lisp and in Clojure.
;In Common Lisp, a "symbol" is a location in memory, a place where data can be stored. The "value" of a symbol is the data stored at that location in memory.
;In Clojure, a "symbol" is just a name. It has no value.
;When the Clojure compiler encounters a symbol, it tries to resolve it as
;a Java class name (if the symbol contains a dot)
;a local (as with "let" or function parameters)
;a Var in the current Namespace
;a Var referred from another Namespace
;The Var, as a previous poster pointed out, represents a storage location.
;There are good reasons why Clojure separates Vars from Symbols. First, it avoids the annoyance of Common Lisp's automatically-interned symbols, which can "pollute" a package with unwanted symbols.
;Secondly, Clojure Vars have special semantics with regard to concurrency. A Var has a exactly one "root binding" visible to all threads. (When you type "def" you are setting the root binding of a Var.) Changes to a Var made within a thread (using "set!" or "binding") are visible only to that thread and its children.


;Symbols in any Lisp are used as identifiers. If you're going to refer to the value of a variable, say, you need to have a way of naming it; that's what symbols are for. Remember that all Lisp code gets translated at read time to Lisp data structures; identifiers must also be represented by some data structure and it happens to be the symbol. Upon encountering a symbol, eval dispatches to some kind of a "name lookup" operation.
;
;Moving from Lisp generalities to Clojure particulars, the behaviour of the Clojure eval / compiler is that upon encountering a symbol, it takes it to be a name for either a let-introduced local variable or function parameter or the name of an entry in a namespace. Actually only non-namespace-qualified symbols may be used in the first capacity (meaning symbols of the form foo and not some-namespace/foo).
;A roughly sketched example:
;For a non-namespace-qualified symbol foo, if a let binding / function parameter of name foo is found, the symbol evaluates to its value. If not, the symbol gets transformed to the form *ns*/foo (*ns* denotes the current namespace) and an attempt is made to look up a curresponding entry in *ns*; if there is such an entry, its value is returned, if not, an exception is thrown.
;
;Note that a symbol like identity, when used in namespace quux, will be resolved to clojure.core/identity through an intermediate step in which an entry under quux/identity is discovered; this will normally refer to clojure.core/identity. That's an implementation detail one doesn't think of when coding intuitively, but which I find impossible not to mention when trying to explain this.
;
;A symbol which is already namespace-qualified (something like a zip/root in a namespace which refers to clojure.zip without use'ing it) will be looked up in the appropriate namespace.
;
;There's some added complexity with macros (which can only occur in operator position), but it's not really something relevant to the behaviour of symbols themselves.
;
;Vars vs Symbols:
;Note that in Clojure, symbols are not themselves storage locations -- Vars are. So when I say in the above that a symbol gets looked up in a namespace, what I mean is that eval looks up the Var named by the symbol resolved to its namespace-qualified form and then takes the value of that. The special form var (often abbreviated to #') modifies this behaviour so that the Var object itself is returned. The mechanics of symbol-to-Var resolution are unchanged, though.

;Closing remarks:
;Note that all this means that symbols are only "bound" to objects in the sense that eval, when evaluating a symbol, goes on to look for some further object. The symbol itself has no "slot" or "field" for an object to be bound to it; any impression that a symbol is "bound" to some object is due to eval's workings. This is a Clojure characteristic, as in some Lisps symbols do themselves act as storage locations.
;Finally, one can use the usual quoting mechanism to prevent the evaluation of a symbol: in 'foo, the symbol foo will not be evaluted (so no name lookup of any sort will be performed); it'll be returned unchanged instead.


(defmacro symbol?? [x]
  (if (symbol? x)
    true
    false))

(def s 1)
(symbol? s)
; => false
(symbol?? s)
; => true
(symbol? 's)
; => true
(symbol?? 's)
; => false

;The last one explained: 's is shorthand for (quote s); this is a list structure, not a symbol. A macro operates on its arguments passed in directly, without being evaluated; so in (symbol?? 's) it actually sees the (quote s) list structure, which is of course not itself a symbol -- although when passed to eval, it would evaluate to one.

