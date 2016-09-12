(ns poligon.hackerrank)

(defn solve-me-first
  "Solution to https://www.hackerrank.com/challenges/fp-solve-me-first"
  []
  (println (+ (Integer/parseInt (read-line))
              (Integer/parseInt (read-line)))))

;; Solution to "Hello World N Times":
;; (fn [n] (dotimes [_ n] (println "Hello World")))

;; Solution to "List Replication"
;; https://www.hackerrank.com/challenges/fp-list-replication
;; (mapcat #(repeat num %) lst)

;; Solution to "Filter Array"
;; https://www.hackerrank.com/challenges/fp-filter-array
(defn filter-array [n nums]
  (reduce #(if (< %2 n) (conj % %2) %) [] nums))

;; https://www.hackerrank.com/challenges/fp-reverse-a-list
(defn reverse-a-list
  [lst]
  (reduce conj '() lst))

;; https://www.hackerrank.com/challenges/fp-list-length
;; (fn [lst] (reduce (fn [n _] (inc n)) 0 lst))

;; Update list:
;; (fn [nums] (map #(Math/abs %) nums))

(defn do-lines-string
  "Read number of input lines N and executes function F N times."
  [f]
  (dotimes [i (Integer/parseInt (read-line))]
    (println (f (.split (read-line) " ")))))

(defn do-lines-long
  "Read whole input and executes function F on lines from 2nd to the end."
  [f]
  (let [i (Integer/parseInt (read-line))]
    (reduce #(conj % (f %2)) [] )
    (doseq [line (rest lines)]
      (println (f (Long/parseLong line))))))

;; (for [i (range (Integer/parseInt (read-line)))
;;       x (Double/parseDouble (read-line))])

(defn read-input
  "Read whole input and executes function F on lines from 2nd to the end."
  [f]
  (let [lines (seq (.split (slurp *in*) "\n"))]
    (map f (rest lines))))

(defn solve-me-second
  "Solution to https://www.hackerrank.com/challenges/solve-me-second"
  [nums]
  (reduce #(+ % (Integer/parseInt %2)) 0 nums))

(defn lonely-integer
  "Solution to https://www.hackerrank.com/challenges/lonely-integer"
  [nums]
  (ffirst (filter #(= (val %) 1) (frequencies nums))))

(defn alternating-characters
  "Solution to https://www.hackerrank.com/challenges/alternating-characters"
  [ar]
  (second (reduce #(if (= (first %) %2)
                     [(first %) (inc (second %))]
                     [%2 (second %)])
                  [0 0] (first ar))))

(defn utopian-tree-size
  "Utopian tree grows in monsoon season * 2, and in summer by +1 meter.
Starts with 1 meter, before monsoon. How many meters will it have after
given number of seasons.
See https://www.hackerrank.com/challenges/utopian-tree"
  ([seasons] (utopian-tree-size seasons 1))
  ([seasons meters]
     (if (> seasons 0)
       (recur (dec seasons)
              (if (even? meters) (inc meters) (* meters 2)))
       meters)))

(defn game-of-thrones
  "Check if given string can be turned into palindrome.
See https://www.hackerrank.com/challenges/game-of-thrones."
  [s]
  (if (> 2 (count (filter #(odd? (val %)) (frequencies s))))
    "YES" "NO"))

(defn is-fibo
  "Determine if `n' is an element of the Fibonacci Sequence.
See https://www.hackerrank.com/challenges/is-fibo"
  [n]
  (loop [prev 2 current 3]
    (cond (<= n 3) "IsFibo"
          (= current n) "IsFibo"
          (< n current) "IsNotFibo"
          :else (recur current (+ prev current)))))

(defn flipping-bits
  "Return a number resulting from flipping bits.
See https://www.hackerrank.com/challenges/flipping-bits"
  [x]
  (loop [i 0 x x]
    (if (= i 32)
      x
      (recur (inc i) (bit-flip x i)))))

(defn maximizing-xor
  "Find maximal XOR value.
See https://www.hackerrank.com/challenges/maximizing-xor"
  ([] (println
       (maximizing-xor (Integer/parseInt (read-line))
                       (Integer/parseInt (read-line)))))
  ([a b]
   (apply max
          (for [i (range a (inc b)) j (range i (inc b))]
            (bit-xor i j)))))

(defn angry-professor
  "Will angry professor cancell the class?
See https://www.hackerrank.com/challenges/angry-professor"
  ([] (angry-professor (slurp *in*)))
  ([s] (let [lines (seq (.split s "\n"))
             cases (rest lines)]
         (loop [cases cases]
           (when (seq cases)
             (let [[_ min-students] (clojure.string/split (first cases) #" ")
                   tseq (map #(Integer/parseInt %)
                             (clojure.string/split (second cases) #" "))]
               (println (angry-professor (Integer/parseInt min-students) tseq))
               (recur (drop 2 cases)))))))
  ([min-required tseq]
   (if (<= min-required (count (filter (complement pos?) tseq)))
     "NO"
     "YES")))
