(ns rna-transcription)

(defn- to-rna-nucleoid [s]
	(cond 
		(= s "C") "G"
		(= s "G") "C"
		(= s "T") "A"
		(= s "A") "U"
		:else (throw (AssertionError. (concat s " is no valid DNA nucleoid")))))

(defn to-rna [s]
	(apply str 
		(map 
			(fn [c]
				(to-rna-nucleoid (str c)))
			(seq s))))