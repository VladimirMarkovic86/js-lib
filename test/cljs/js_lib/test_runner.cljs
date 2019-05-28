(ns js-lib.test-runner
  (:require [js-lib.core-test-cljs]
            [doo.runner :refer-macros [doo-tests doo-all-tests]]))

(enable-console-print!)

(doo-tests
  'js-lib.core-test-cljs)

