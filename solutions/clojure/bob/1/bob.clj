(ns bob
	(require [clojure.string :as string]))

(defn- contains-chars?
	[request]
	(not
		(nil? 
			(re-find #"[a-zA-Z]" request))))

(defn- speechless? 
	[request]
	(string/blank? request))

(defn- yelling?
	"checks if you yelled at bob"
	[request]
	(and 
		(contains-chars? request)
		(= (string/upper-case request) request)))

(defn- question?
	"checks if this is a question to bob"
	[request]
	(= (last request) \?))

(defn response-for 
	"gets a response from bob"
	[request]
	(cond
		(speechless? request) "Fine. Be that way!"
		(yelling? request) "Whoa, chill out!"
		(question? request) "Sure."
		:else "Whatever."))