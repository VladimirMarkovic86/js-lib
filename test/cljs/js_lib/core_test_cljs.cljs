(ns js-lib.core-test-cljs
  (:require [clojure.test :refer-macros [deftest is testing]]
            [js-lib.core :refer [get-url html? convert-to-vector query-selector
                                 query-selector-all query-selector-on-element
                                 query-selector-all-on-element get-by-id get-by-class
                                 xpath get-child-nodes parse-html determine-param-type
                                 is-valid? get-value get-value-as-number get-value-as-date
                                 set-value get-checked set-checked get-src set-src get-type
                                 get-parent ancestor replace-single replace-all empty-nodes
                                 get-inner-html set-inner-html get-outer-html
                                 set-outer-html get-selected-options add-fn-to-event
                                 event remove-fn-from-event remove-event
                                 remove-all-fns-from-event remove-all-event prepend-element
                                 append-element content remove-element
                                 remove-element-content remove-element-from-element
                                 timeout get-attr set-attr set-attrs get-class-list
                                 get-node-name add-class remove-class contains-class
                                 element-exists fade-anim-append fade-in-iteration
                                 fade-in fade-out start-please-wait end-please-wait
                                 update-progress-bar start-progress-bar
                                 end-progress-bar is-checked? checked-value-with-index
                                 checked-value cb-checked-values fade-out-and-fade-in
                                 find-event-type init-event dispatch-event
                                 get-next-siblings get-previous-siblings
                                 get-all-siblings]]))

(deftest test-get-url
  (testing "Test get url"
    
    (let [result (get-url)]
      (is
        (= result
           "http://localhost:9876/context.html")
       )
     )
    
   ))

(deftest test-html?
  (testing "Test html?"
    
    (let [data nil
          result (html?
                   data)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [data "test"
          result (html?
                   data)]
      
      (is
        (false?
          result)
       )
      
     )
    
    (let [data (.createElement
                 js/document
                 "div")
          result (html?
                   data)]
      
      (is
        (true?
          result)
       )
      
     )
    
   ))

(deftest test-convert-to-vector
  (testing "Test convert to vector"
    
    (let [node-list nil
          result (convert-to-vector
                   node-list)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [node-list (.querySelectorAll
                      js/document
                      "body")
          result (convert-to-vector
                   node-list)
          node-element (.querySelector
                         js/document
                         "body")]
      
      (is
        (= result
          [node-element])
       )
      
     )
    
   ))

(deftest test-query-selector
  (testing "Test query selector"
    
    (let [selector nil
          result (query-selector
                   selector)]
      (is
        (nil?
          result)
       )
     )
    
    (let [selector "test"
          result (query-selector
                   selector)]
      (is
        (nil?
          result)
       )
     )
    
    (let [selector "body"
          result (query-selector
                   selector)
          body-element (.querySelector
                         js/document
                         "body")]
      (is
        (= result
           body-element)
       )
     )
    
   ))

(deftest test-query-selector-all
  (testing "Test query selector all"
    
    (let [selector nil
          result (query-selector-all
                   selector)]
      
      (is
        (= result
           [])
       )
      
     )
    
    (let [selector "test"
          result (query-selector-all
                   selector)]
      
      (is
        (= result
           [])
       )
      
     )
    
    (let [selector "body"
          result (query-selector-all
                   selector)
          body-element (.querySelector
                         js/document
                         "body")]
      
      (is
        (= result
           [body-element])
       )
      
     )
    
   ))

(deftest test-query-selector-on-element
  (testing "Test query selector on element"
    
    (let [element nil
          selector nil
          result (query-selector-on-element
                   element
                   selector)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element "test"
          selector "test2"
          result (query-selector-on-element
                   element
                   selector)
          body-element (.querySelector
                         js/document
                         "body")]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element "html"
          selector "body"
          result (query-selector-on-element
                   element
                   selector)
          body-element (.querySelector
                         js/document
                         "body")]
      
      (is
        (= result
           body-element)
       )
      
     )
    
    (let [element (.querySelector
                    js/document
                    "html")
          selector "body"
          result (query-selector-on-element
                   element
                   selector)
          body-element (.querySelector
                         js/document
                         "body")]
      
      (is
        (= result
           body-element)
       )
      
     )
    
    (let [element (.querySelector
                    js/document
                    "html")
          selector (.querySelector
                     js/document
                     "body")
          result (query-selector-on-element
                   element
                   selector)
          body-element (.querySelector
                         js/document
                         "body")]
      
      (is
        (= result
           body-element)
       )
      
     )
    
   ))

(deftest test-query-selector-all-on-element
  (testing "Test query selector all on element"
    
    (let [element nil
          selector nil
          result (query-selector-all-on-element
                   element
                   selector)]
      
      (is
        (= result
           [])
       )
      
     )
    
    (let [element "test"
          selector "test2"
          result (query-selector-all-on-element
                   element
                   selector)]
      
      (is
        (= result
           [])
       )
      
     )
    
    (let [element "html"
          selector "body"
          result (query-selector-all-on-element
                   element
                   selector)
          body-element (.querySelector
                         js/document
                         "body")]
      
      (is
        (= result
           [body-element])
       )
      
     )
    
    (let [element (.querySelector
                    js/document
                    "html")
          selector "body"
          result (query-selector-all-on-element
                   element
                   selector)
          body-element (.querySelector
                         js/document
                         "body")]
      
      (is
        (= result
           [body-element])
       )
      
     )
    
   ))

(deftest test-get-by-id
  (testing "Test get by id"
    
    (let [element-id nil
          result (get-by-id
                   element-id)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element-id "test"
          result (get-by-id
                   element-id)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [body-element (.querySelector
                         js/document
                         "body")
          div-with-id (.createElement
                        js/document
                        "div")
          void (.setAttribute
                 div-with-id
                 "id"
                 "test-id")
          void (append-element
                 body-element
                 div-with-id)
          element-id "test-id"
          result (get-by-id
                   element-id)]
      
      (is
        (= result
           div-with-id)
       )
      
     )
    
   ))

(deftest test-get-by-class
  (testing "Test get by class"
    
    (let [element-class nil
          result (get-by-class
                   element-class)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element-class "test"
          result (get-by-class
                   element-class)]
      
      (is
        (nil?
          (aget
            result
            0))
       )
      
     )
    
    (let [body-element (.querySelector
                         js/document
                         "body")
          div-with-class (.createElement
                           js/document
                           "div")
          void (.setAttribute
                 div-with-class
                 "class"
                 "test-class")
          void (append-element
                 body-element
                 div-with-class)
          element-class "test-class"
          result (get-by-class
                   element-class)]
      
      (is
        (html?
          (aget
            result
            0))
       )
      
     )
    
   ))

(deftest test-xpath
  (testing "Test xpath"
    
    (let [selector nil
          result (xpath
                   selector)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [selector "test"
          result (xpath
                   selector)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [body-element (.querySelector
                         js/document
                         "body")
          div-for-xpath (.createElement
                          js/document
                          "div")
          void (append-element
                 div-for-xpath
                 "Test xpath")
          void (append-element
                 body-element
                 div-for-xpath)
          selector "//div[contains(text(), 'Test xpath')]"
          result (xpath
                   selector)]
      
      (is
        (html?
          result)
       )
      
      (is
        (= (.-innerHTML
             result)
           "Test xpath")
       )
      
     )
    
   ))

(deftest test-get-child-nodes
  (testing "Test get child nodes"
    
    (let [element nil
          result (get-child-nodes
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          div-element-i (.createElement
                          js/document
                          "div")
          div-element-ii (.createElement
                           js/document
                           "div")
          void (append-element
                 div-element
                 div-element-i)
          void (append-element
                 div-element
                 div-element-ii)
          element div-element
          result (get-child-nodes
                   element)]
      
      (is
        (vector?
          result)
       )
      
      (is
        (= (count
             result)
           2)
       )
      
     )
    
   ))

(deftest test-parse-html
  (testing "Test parse html"
    
    (let [html-content nil
          result (parse-html
                   html-content)]
      
      (is
        (= result
           [])
       )
      
     )
    
    (let [html-content "<div></div><div></div>"
          result (parse-html
                   html-content)]
      
      (is
        (= (count
             result)
           2)
       )
      
      (is
        (html?
          (get
            result
            0))
       )
      
      (is
        (html?
          (get
            result
            1))
       )
      
     )
    
   ))

(deftest test-determine-param-type
  (testing "Test determine param type"
    
    (let [exec-fn nil
          param nil
          result (determine-param-type
                   exec-fn
                   param)]
      
      (is
        (= result
           [])
       )
      
     )
    
    (let [exec-fn nil
          param "<div></div>"
          result (determine-param-type
                   exec-fn
                   param)]
      
      (is
        (= result
           [])
       )
      
     )
    
    (let [exec-fn parse-html
          param "<div></div>"
          result (determine-param-type
                   exec-fn
                   param)]
      
      (is
        (= (count
             result)
           1)
       )
      
      (is
        (html?
          (first
            result))
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          exec-fn nil
          param div-element
          result (determine-param-type
                   exec-fn
                   param)]
      
      (is
        (html?
          result)
       )
      
     )
    
    (let [exec-fn nil
          param [1 2 3]
          result (determine-param-type
                   exec-fn
                   param)]
      
      (is
        (= result
           [1 2 3])
       )
      
     )
    
   ))

(deftest test-is-valid?
  (testing "Test is valid?"
    
    (let [element nil
          result (is-valid?
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element "test"
          result (is-valid?
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [text-element (.createElement
                         js/document
                         "input")
          void (.setAttribute
                 text-element
                 "type"
                 "text")
          void (.setAttribute
                 text-element
                 "required"
                 "required")
          element text-element
          result (is-valid?
                   element)]
      
      (is
        (false?
          result)
       )
      
     )
    
    (let [text-element (.createElement
                         js/document
                         "input")
          void (.setAttribute
                 text-element
                 "type"
                 "text")
          void (.setAttribute
                 text-element
                 "required"
                 "required")
          void (aset
                 text-element
                 "value"
                 "Test text")
          element text-element
          result (is-valid?
                   element)]
      
      (is
        (true?
          result)
       )
      
     )
    
   ))

(deftest test-get-value
  (testing "Test get value"
    
    (let [element nil
          result (get-value
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element "test"
          result (get-value
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [text-element (.createElement
                         js/document
                         "input")
          void (.setAttribute
                 text-element
                 "type"
                 "text")
          void (.setAttribute
                 text-element
                 "required"
                 "required")
          void (aset
                 text-element
                 "value"
                 "Test text")
          void (append-element
                 "body"
                 text-element)
          element "input[type='text']"
          result (get-value
                   element)]
      
      (is
        (= result
           "Test text")
       )
      
     )
    
    (let [text-element (.createElement
                         js/document
                         "input")
          void (.setAttribute
                 text-element
                 "type"
                 "text")
          void (.setAttribute
                 text-element
                 "required"
                 "required")
          void (aset
                 text-element
                 "value"
                 "Test text")
          element text-element
          result (get-value
                   element)]
      
      (is
        (= result
           "Test text")
       )
      
     )
    
   ))

(deftest test-get-value-as-number
  (testing "Test get value as number"
    
    (let [element nil
          result (get-value-as-number
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element "test"
          result (get-value-as-number
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [text-element (.createElement
                         js/document
                         "input")
          void (.setAttribute
                 text-element
                 "type"
                 "number")
          void (.setAttribute
                 text-element
                 "required"
                 "required")
          void (aset
                 text-element
                 "value"
                 "1")
          void (append-element
                 "body"
                 text-element)
          element "input[type='number']"
          result (get-value-as-number
                   element)]
      
      (is
        (= result
           1)
       )
      
     )
    
    (let [text-element (.createElement
                         js/document
                         "input")
          void (.setAttribute
                 text-element
                 "type"
                 "number")
          void (.setAttribute
                 text-element
                 "required"
                 "required")
          void (aset
                 text-element
                 "value"
                 "1")
          element text-element
          result (get-value-as-number
                   element)]
      
      (is
        (= result
           1)
       )
      
     )
    
   ))

(deftest test-get-value-as-date
  (testing "Test get value as date"
    
    (let [element nil
          result (get-value-as-date
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [text-element (.createElement
                         js/document
                         "input")
          void (.setAttribute
                 text-element
                 "type"
                 "date")
          void (.setAttribute
                 text-element
                 "required"
                 "required")
          void (aset
                 text-element
                 "value"
                 "1986-10-16")
          void (append-element
                 "body"
                 text-element)
          element "input[type='date']"
          result (get-value-as-date
                   element)]
      
      (is
        (= result
           (js/Date.
             "1986-10-16"))
       )
      
     )
    
    (let [text-element (.createElement
                         js/document
                         "input")
          void (.setAttribute
                 text-element
                 "type"
                 "date")
          void (.setAttribute
                 text-element
                 "required"
                 "required")
          void (aset
                 text-element
                 "value"
                 "1986-10-16")
          element text-element
          result (get-value-as-date
                   element)]
      
      (is
        (= result
           (js/Date.
             "1986-10-16"))
       )
      
     )
    
   ))

(deftest test-set-value
  (testing "Test set value"
    
    (let [element nil
          new-value nil
          result (set-value
                   element
                   new-value)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element "test"
          new-value "test"
          result (set-value
                   element
                   new-value)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [text-element (.createElement
                         js/document
                         "input")
          void (.setAttribute
                 text-element
                 "type"
                 "text")
          void (.setAttribute
                 text-element
                 "required"
                 "required")
          element text-element
          new-value "Test set value"
          result (set-value
                   element
                   new-value)]
      
      (is
        (= (aget
             element
             "value")
           "Test set value")
       )
      
     )
    
    (let [text-element (.createElement
                         js/document
                         "input")
          void (.setAttribute
                 text-element
                 "type"
                 "text")
          void (.setAttribute
                 text-element
                 "required"
                 "required")
          void (append-element
                 "body"
                 text-element)
          element "input[type='text']"
          new-value "Test set value"
          result (set-value
                   element
                   new-value)]
      
      (is
        (= (aget
             (query-selector
               "input[type='text']")
             "value")
           "Test set value")
       )
      
     )
    
   ))

(deftest test-get-checked
  (testing "Test get checked"
    
    (let [element nil
          result (get-checked
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element "test"
          result (get-checked
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [radio-element (.createElement
                          js/document
                          "input")
          void (.setAttribute
                 radio-element
                 "type"
                 "radio")
          element radio-element
          result (get-checked
                   element)]
      
      (is
        (false?
          result)
       )
      
     )
    
    (let [radio-element (.createElement
                          js/document
                          "input")
          void (.setAttribute
                 radio-element
                 "type"
                 "radio")
          void (append-element
                 "body"
                 radio-element)
          element "input[type='radio']"
          result (get-checked
                   element)]
      
      (is
        (false?
          result)
       )
      
     )
    
    (let [checkbox-element (.createElement
                             js/document
                             "input")
          void (.setAttribute
                 checkbox-element
                 "type"
                 "checkbox")
          element checkbox-element
          result (get-checked
                   element)]
      
      (is
        (false?
          result)
       )
      
     )
    
    (let [checkbox-element (.createElement
                             js/document
                             "input")
          void (.setAttribute
                 checkbox-element
                 "type"
                 "checkbox")
          void (append-element
                 "body"
                 checkbox-element)
          element "input[type='checkbox']"
          result (get-checked
                   element)]
      
      (is
        (false?
          result)
       )
      
     )
    
   ))

(deftest test-set-checked
  (testing "Test set checked"
    
    (let [element nil
          new-value nil
          result (set-checked
                   element
                   new-value)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element "test"
          new-value "test"
          result (set-checked
                   element
                   new-value)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [checkbox-element (.createElement
                             js/document
                             "input")
          void (.setAttribute
                 checkbox-element
                 "type"
                 "checkbox")
          element checkbox-element
          new-value true
          result (set-checked
                   element
                   new-value)]
            
      (is
        (true?
          (aget
            checkbox-element
            "checked"))
       )
      
     )
    
    (let [checkbox-element (.createElement
                             js/document
                             "input")
          void (.setAttribute
                 checkbox-element
                 "type"
                 "checkbox")
          void (append-element
                 "body"
                 checkbox-element)
          element "input[type='checkbox']"
          new-value true
          result (set-checked
                   element
                   new-value)]
      
      (is
        (true?
          (aget
            (query-selector
              "input[type='checkbox']")
            "checked"))
       )
      
     )
    
    (let [checkbox-element (.createElement
                             js/document
                             "input")
          void (.setAttribute
                 checkbox-element
                 "type"
                 "checkbox")
          void (append-element
                 "body"
                 checkbox-element)
          element "input[type='checkbox']"
          new-value "false"
          result (set-checked
                   element
                   new-value)]
      
      (is
        (true?
          (aget
            (query-selector
              "input[type='checkbox']")
            "checked"))
       )
      
     )
    
   ))

(deftest test-get-src
  (testing "Test get src"
    
    (let [element nil
          result (get-src
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element "test"
          result (get-src
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [img-element (.createElement
                        js/document
                        "img")
          void (.setAttribute
                 img-element
                 "src"
                 "src_path")
          element img-element
          result (get-src
                   element)]
      
      (is
        (= result
           "http://localhost:9876/src_path")
       )
      
     )
    
    (let [img-element (.createElement
                        js/document
                        "img")
          void (.setAttribute
                 img-element
                 "src"
                 "src_path")
          void (append-element
                 "body"
                 img-element)
          element "img[src]"
          result (get-src
                   element)]
      
      (is
        (= result
           "http://localhost:9876/src_path")
       )
      
     )
    
   ))

(deftest test-set-src
  (testing "Test set src"
    
    (let [element nil
          new-value nil
          result (set-src
                   element
                   new-value)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element "test"
          new-value "test"
          result (set-src
                   element
                   new-value)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [img-element (.createElement
                        js/document
                        "img")
          element img-element
          new-value "src_test_path"
          result (set-src
                   element
                   new-value)]
      
      (is
        (= (get-src
             element)
           "http://localhost:9876/src_test_path")
       )
      
     )
    
    (let [img-element (.createElement
                        js/document
                        "img")
          void (append-element
                 "body"
                 img-element)
          element "img"
          new-value "src_test_path"
          result (set-src
                   element
                   new-value)]
      
      (is
        (= (get-src
             element)
           "http://localhost:9876/src_test_path")
       )
      
     )
    
   ))

(deftest test-get-type
  (testing "Test get type"
    
    (let [element nil
          result (get-type
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element "test"
          result (get-type
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element (.createElement
                    js/document
                    "div")
          void (aset
                 element
                 "type"
                 "type_value")
          result (get-type
                   element)]
      
      (is
        (= result
           "type_value")
       )
      
     )
    
   ))

(deftest test-get-parent
  (testing "Test get parent"
    
    (let [element nil
          result (get-parent
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element "test"
          result (get-parent
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          element div-element
          result (get-parent
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          void (append-element
                 "body"
                 div-element)
          element "div"
          result (get-parent
                   element)]
      
      (is
        (html?
          result)
       )
      
     )
    
   ))

(deftest test-ancestor
  (testing "Test ancestor"
    
    (let [element nil
          ancestor-level nil
          result (ancestor
                   element
                   ancestor-level)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element "test"
          ancestor-level "test"
          result (ancestor
                   element
                   ancestor-level)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          void (append-element
                 "body"
                 div-element)
          element div-element
          ancestor-level 1
          result (ancestor
                   element
                   ancestor-level)]
      
      (is
        (= (.toString
             result)
           "[object HTMLBodyElement]")
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          void (append-element
                 "body"
                 div-element)
          element div-element
          ancestor-level 2
          result (ancestor
                   element
                   ancestor-level)]
      
      (is
        (= (.toString
             result)
           "[object HTMLHtmlElement]")
       )
      
     )
    
   ))

(deftest test-replace-single
  (testing "Test replace single"
    
    (let [str-content nil
          replace-this nil
          replace-with nil
          result (replace-single
                   str-content
                   replace-this
                   replace-with)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [str-content "test1 test2 test3 test2 test4"
          replace-this "test2"
          replace-with "test-inserted"
          result (replace-single
                   str-content
                   replace-this
                   replace-with)]
      
      (is
        (= result
           "test1 test-inserted test3 test2 test4")
       )
      
     )
    
   ))

(deftest test-replace-all
  (testing "Test replace all"
    
    (let [str-content nil
          replace-this nil
          replace-with nil
          result (replace-all
                   str-content
                   replace-this
                   replace-with)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [str-content "test1 test2 test3 test2 test4"
          replace-this "test2"
          replace-with "test-inserted"
          result (replace-all
                   str-content
                   replace-this
                   replace-with)]
      
      (is
        (= result
           "test1 test-inserted test3 test-inserted test4")
       )
      
     )
    
   ))

(deftest test-empty-nodes
  (testing "Test empty nodes"
    
    (let [selector nil
          result (empty-nodes
                   selector)]
      
      (is
        (nil?
          selector)
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          void (.setAttribute
                 div-element
                 "class"
                 "div-to-empty")
          div-element-i (.createElement
                          js/document
                          "div")
          div-element-ii (.createElement
                           js/document
                           "div")
          void (append-element
                 div-element
                 div-element-i)
          void (append-element
                 div-element
                 div-element-ii)
          void (append-element
                 "body"
                 div-element)
          selector ".div-to-empty"
          result (empty-nodes
                   selector)
          children (get-child-nodes
                     div-element)]
      
      (is
        (= children
           [])
       )
      
     )
    
   ))

(deftest test-get-inner-html
  (testing "Test get inner html"
    
    (let [element nil
          result (get-inner-html
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          void (append-element
                 div-element
                 "Test content")
          element div-element
          result (get-inner-html
                   element)]
      
      (is
        (= result
           "Test content")
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          void (.setAttribute
                 div-element
                 "class"
                 "test-get-inner-html")
          void (append-element
                 div-element
                 "Test content")
          void (append-element
                 "body"
                 div-element)
          element ".test-get-inner-html"
          result (get-inner-html
                   element)]
      
      (is
        (= result
           "Test content")
       )
      
     )
    
   ))

(deftest test-set-inner-html
  (testing "Test set inner html"
    
    (let [selector nil
          html-content nil
          result (set-inner-html
                   selector
                   html-content)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [selector "body"
          html-content "set inner html"
          result (set-inner-html
                   selector
                   html-content)]
      
      (is
        (= (get-inner-html
             "body")
           html-content)
       )
      
     )
    
    (let [body-element (query-selector
                         "body")
          selector body-element
          html-content "set inner html"
          result (set-inner-html
                   selector
                   html-content)]
      
      (is
        (= (get-inner-html
             "body")
           html-content)
       )
      
     )
    
   ))

(deftest test-get-outer-html
  (testing "Test get outer html"
    
    (let [selector nil
          result (get-outer-html
                   selector)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [selector "body"
          html-content "Replaced content"
          void (set-inner-html
                 selector
                 html-content)
          result (get-outer-html
                   selector)]
      
      (is
        (= result
           "<body>Replaced content</body>")
       )
      
     )
    
   ))

(deftest test-set-outer-html
  (testing "Test set outer html"
    
    (let [selector nil
          html-content nil
          result (set-outer-html
                   selector
                   html-content)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [selector "body"
          html-content "<body><div></div></body>"
          result (set-outer-html
                   selector
                   html-content)]
      
      (is
        (= (get-outer-html
             selector)
           html-content)
       )
      
     )
    
   ))

(deftest test-get-selected-options
  (testing "Test get selected options"
    
    (let [element nil
          result (get-selected-options
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [select-element (.createElement
                           js/document
                           "select")
          option-element1 (.createElement
                            js/document
                            "option")
          void (set-inner-html
                 option-element1
                 "option1")
          option-element2 (.createElement
                            js/document
                            "option")
          void (set-inner-html
                 option-element2
                 "option2")
          void (append-element
                 select-element
                 option-element1)
          void (append-element
                 select-element
                 option-element2)
          element select-element
          result (get-selected-options
                   element)]
      
      (is
        (= result
           {:label "option1"})
       )
      
     )
    
    (let [select-element (.createElement
                           js/document
                           "select")
          void (.setAttribute
                 select-element
                 "id"
                 "select-element")
          option-element1 (.createElement
                            js/document
                            "option")
          void (set-inner-html
                 option-element1
                 "option1")
          option-element2 (.createElement
                            js/document
                            "option")
          void (set-inner-html
                 option-element2
                 "option2")
          void (append-element
                 select-element
                 option-element1)
          void (append-element
                 select-element
                 option-element2)
          void (append-element
                 "body"
                 select-element)
          element "#select-element"
          result (get-selected-options
                   element)]
      
      (is
        (= result
           {:label "option1"})
       )
      
     )
    
   ))

(deftest test-add-fn-to-event
  (testing "Test add fn to event"
    
    (let [element nil
          event-type nil
          event-function nil
          fn-params nil
          result (add-fn-to-event
                   element
                   event-type
                   event-function
                   fn-params)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element "test"
          event-type "test"
          event-function "test"
          fn-params nil
          result (add-fn-to-event
                   element
                   event-type
                   event-function
                   fn-params)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element (.createElement
                    js/document
                    "div")
          event-type "test-event-type"
          event-function (fn [fn-p
                              el])
          fn-params nil
          result (add-fn-to-event
                   element
                   event-type
                   event-function
                   fn-params)]
      
      (is
        (not
          (nil?
            result))
       )
      
      (is
        (contains?
          (aget
            element
            (str
              event-type
              "-funcs"))
          "function(fn_p,el){return null}"))
      
     )
    
   ))

(deftest test-event
  (testing "Test event"
    
    (let [element nil
          event-type nil
          event-function nil
          fn-params nil
          result (event
                   element
                   event-type
                   event-function
                   fn-params)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element (.createElement
                    js/document
                    "div")
          event-type "test-event-type"
          event-function (fn [fn-p
                              el])
          fn-params nil
          result (event
                   element
                   event-type
                   event-function
                   fn-params)]
      
      (is
        (not
          (nil?
            result))
       )
      
      (is
        (contains?
          (aget
            element
            (str
              event-type
              "-funcs"))
          "function(fn_p,el){return null}"))
      
     )
    
    (let [element1 (.createElement
                     js/document
                     "div")
          element2 (.createElement
                     js/document
                     "div")
          event-type "test-event-type"
          event-function (fn [fn-p
                              el])
          fn-params nil
          result (event
                   [element1
                    element2]
                   event-type
                   event-function
                   fn-params)]
      
      (is
        (nil?
          result)
       )
      
      (doseq [el [element1
                  element2]]
        (is
          (contains?
            (aget
              el
              (str
                event-type
                "-funcs"))
            "function(fn_p,el){return null}"))
       )
      
     )
    
   ))

(deftest test-remove-fn-from-event
  (testing "Test remove fn from event"
    
    (let [element nil
          event-type nil
          event-function nil
          result (remove-fn-from-event
                   element
                   event-type
                   event-function)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element (.createElement
                    js/document
                    "div")
          event-type "test-event-type"
          event-function-1 (fn [fn-p
                                el])
          void (event
                 element
                 event-type
                 event-function-1)
          event-function-2 (fn [fn-p-2
                                el-2])
          void (event
                 element
                 event-type
                 event-function-2)]
      
      (is
        (contains?
          (aget
            element
            (str
              event-type
              "-funcs"))
          "function(fn_p,el){return null}")
       )
      
      (is
        (contains?
          (aget
            element
            (str
              event-type
              "-funcs"))
          "function(fn_p_2,el_2){return null}")
       )
      
      (remove-fn-from-event
        element
        event-type
        event-function-1)
      
      (is
        (false?
          (contains?
            (aget
              element
              (str
                event-type
                "-funcs"))
            "function(fn_p,el){return null}"))
       )
      
      (is
        (contains?
          (aget
            element
            (str
              event-type
              "-funcs"))
          "function(fn_p_2,el_2){return null}")
       )
      
     )
    
   ))

(deftest test-remove-event
  (testing "Test remove event"
    
    (let [element nil
          event-type nil
          event-function nil
          result (remove-event
                   element
                   event-type
                   event-function)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element (.createElement
                    js/document
                    "div")
          event-type "test-event-type"
          event-function (fn [fn-p
                              el])]
      
      (event
        element
        event-type
        event-function)
      
      (is
        (contains?
          (aget
            element
            (str
              event-type
              "-funcs"))
          "function(fn_p,el){return null}")
       )
      
      (remove-event
        element
        event-type
        event-function)
      
      (is
        (false?
          (contains?
            (aget
              element
              (str
                event-type
                "-funcs"))
            "function(fn_p,el){return null}"))
       )
      
     )
    
   ))

(deftest test-remove-all-fns-from-event
  (testing "Test remove all fns from event"
    
    (let [element nil
          event-type nil
          result (remove-all-fns-from-event
                   element
                   event-type)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element (.createElement
                    js/document
                    "div")
          event-type "test-event-type"
          event-function (fn [fn-p
                              el])]
      
      (event
        element
        event-type
        event-function)
      
      (is
        (contains?
          (aget
            element
            (str
              event-type
              "-funcs"))
          "function(fn_p,el){return null}")
       )
      
      (remove-all-fns-from-event
        element
        event-type)
      
      (is
        (false?
          (contains?
            (aget
              element
              (str
                event-type
                "-funcs"))
            "function(fn_p,el){return null}"))
       )
      
     )
    
   ))

(deftest test-remove-all-event
  (testing "Test remove all event"
    
    (let [element nil
          event-type nil
          result (remove-all-event
                   element
                   event-type)]
      
      (is
        (nil?
          element)
       )
      
     )
    
    (let [element (.createElement
                    js/document
                    "div")
          event-type "test-event-type"
          event-function (fn [fn-p
                              el])]
      
      (event
        element
        event-type
        event-function)
      
      (is
        (contains?
          (aget
            element
            (str
              event-type
              "-funcs"))
          "function(fn_p,el){return null}")
       )
      
      (remove-all-event
        element
        event-type)
      
      (is
        (nil?
          (aget
            element
            (str
              event-type
              "-funcs"))
         )
       )
      
     )
    
   ))

(deftest test-prepend-element
  (testing "Test prepend element"
    
    (let [selector nil
          html-content nil
          result (prepend-element
                   selector
                   html-content)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [prepend-span (.createElement
                         js/document
                         "span")
          selector "body"
          html-content prepend-span
          result (prepend-element
                   selector
                   html-content)]
      
      (is
        (= (.indexOf
             (get-inner-html
               selector)
             "<span></span>")
           0)
       )
      
     )
    
   ))

(deftest test-append-element
  (testing "Test append element"
    
    (let [selector nil
          html-content nil
          result (append-element
                   selector
                   html-content)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [append-el (.createElement
                      js/document
                      "span")
          selector "body"
          html-content append-el]
      
      (append-element
        selector
        html-content)
      
      (let [body-inner-html (get-inner-html
                              selector)
            body-inner-html-length (count
                                     body-inner-html)]
        
        (is
          (= (.lastIndexOf
               body-inner-html
               "<span></span>")
             (- body-inner-html-length
                13))
         )
        
       )
      
     )
    
   ))

(deftest test-content
  (testing "Test content"
    
    (let [selector nil
          html-content nil
          result (content
                   selector
                   html-content)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [selector "body"
          html-content nil
          result (content
                   selector
                   html-content)]
      
      (is
        (= (get-inner-html
             selector)
           "")
       )
      
     )
    
    (let [selector "body"
          html-content "<span></span>"
          result (content
                   selector
                   html-content)]
      
      (is
        (= (get-inner-html
             selector)
           html-content)
       )
      
     )
    
   ))

(deftest test-remove-element
  (testing "Test remove element"
    
    (let [selector nil
          result (remove-element
                   selector)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element-1 (.createElement
                      js/document
                      "div")
          void (append-element
                 "body"
                 element-1)
          element-2 (.createElement
                      js/document
                      "div")
          void (append-element
                 "body"
                 element-2)
          selector "div"]
      
      (is
        (not
          (nil?
            (query-selector
              selector))
         )
       )
      
      (remove-element
        selector)
      
      (is
        (nil?
          (query-selector
            selector))
       )
      
     )
    
   ))

(deftest test-remove-element-content
  (testing "Test remove element content"
    
    (let [selector nil
          result (remove-element-content
                   selector)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [content-element (.createElement
                            js/document
                            "div")
          span-element-1 (.createElement
                           js/document
                           "span")
          void (append-element
                 content-element
                 span-element-1)
          span-element-2 (.createElement
                           js/document
                           "span")
          void (append-element
                 content-element
                 span-element-2)
          selector content-element]
      
      (is
        (= (get-inner-html
             selector)
           "<span></span><span></span>")
       )
      
      (remove-element-content
        selector)
      
      (is
        (empty?
          (get-inner-html
            selector))
       )
      
     )
    
    (let [content-element (.createElement
                            js/document
                            "div")
          void (.setAttribute
                 content-element
                 "id"
                 "div-element")
          span-element-1 (.createElement
                           js/document
                           "span")
          void (append-element
                 content-element
                 span-element-1)
          span-element-2 (.createElement
                           js/document
                           "span")
          void (append-element
                 content-element
                 span-element-2)
          void (append-element
                 "body"
                 content-element)
          selector "#div-element"]
      
      (is
        (= (get-inner-html
             selector)
           "<span></span><span></span>")
       )
      
      (remove-element-content
        selector)
      
      (is
        (empty?
          (get-inner-html
            selector))
       )
      
     )
    
   ))

(deftest test-remove-element-from-element
  (testing "Test remove element from element"
    
    (let [element nil
          selector nil
          result (remove-element-from-element
                   element
                   selector)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [content-element (.createElement
                            js/document
                            "div")
          span-element-1 (.createElement
                           js/document
                           "span")
          void (append-element
                 content-element
                 span-element-1)
          span-element-2 (.createElement
                           js/document
                           "span")
          void (append-element
                 content-element
                 span-element-2)
          div-element (.createElement
                        js/document
                        "div")
          void (append-element
                 content-element
                 div-element)
          element content-element
          selector "span"]
      
      (is
        (= (get-inner-html
             element)
           "<span></span><span></span><div></div>")
       )
      
      (remove-element-from-element
        [element]
        selector)
      
      (is
        (= (get-inner-html
             element)
           "<div></div>")
       )
      
     )
    
    (let [content-element (.createElement
                            js/document
                            "div")
          void (.setAttribute
                 content-element
                 "id"
                 "div-content")
          span-element-1 (.createElement
                           js/document
                           "span")
          void (append-element
                 content-element
                 span-element-1)
          span-element-2 (.createElement
                           js/document
                           "span")
          void (append-element
                 content-element
                 span-element-2)
          div-element (.createElement
                        js/document
                        "div")
          void (append-element
                 content-element
                 div-element)
          void (append-element
                 "body"
                 content-element)
          element "#div-content"
          selector "span"]
      
      (is
        (= (get-inner-html
             element)
           "<span></span><span></span><div></div>")
       )
      
      (remove-element-from-element
        [element]
        selector)
      
      (is
        (= (get-inner-html
             element)
           "<div></div>")
       )
      
     )
    
   ))

(deftest test-timeout
  (testing "Test timeout"
    
    (let [execute-fn nil
          delay-time nil
          result (timeout
                   execute-fn
                   delay-time)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [timeout-test-a (atom "test")
          execute-fn (fn []
                       (reset!
                         timeout-test-a
                         "test success"))
          delay-time 500]
      
      (timeout
        execute-fn
        delay-time)
      
      (is
        (= @timeout-test-a
           "test")
       )
      
      (timeout
        (fn []
          (is
            (= @timeout-test-a
               "test success")
           ))
        delay-time)
      
     )
    
   ))

(deftest test-get-attr
  (testing "Test get attr"
    
    (let [element nil
          attr-name nil
          result (get-attr
                   element
                   attr-name)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          void (.setAttribute
                 div-element
                 "attribute-test"
                 "value-test")
          element div-element
          attr-name "attribute-test"
          result (get-attr
                   element
                   attr-name)]
      
      (is
        (= result
           "value-test")
       )
      
     )
    
   ))

(deftest test-set-attr
  (testing "Test set attr"
    
    (let [element nil
          attr-name nil
          value nil]
      
      (set-attr
        element
        attr-name
        value)
      
      (is
        (= (get-attr
             element
             attr-name)
           value)
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          element div-element
          attr-name "test-attribute"
          value "test-value"]
      
      (set-attr
        element
        attr-name
        value)
      
      (is
        (= (get-attr
             element
             attr-name)
           value)
       )
      
     )
    
   ))

(deftest test-set-attrs
  (testing "Test set attrs"
    
    (let [elements nil
          attr-name nil
          value nil
          result (set-attrs
                   elements
                   attr-name
                   value)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element-1 (.createElement
                      js/document
                      "div")
          element-2 (.createElement
                      js/document
                      "div")
          elements [element-1
                    element-2]
          attr-name "test-attribute"
          value "test-value"]
      
      (set-attrs
        elements
        attr-name
        value)
      
      (doseq [element elements]
        (is
          (= (get-attr
               element
               attr-name)
             value)
         )
       )
      
     )
    
   ))

(deftest test-get-class-list
  (testing "Test get class list"
    
    (let [element nil
          result (get-class-list
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [element ""
          result (get-class-list
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          void (.setAttribute
                 div-element
                 "class"
                 "test-class test-class2")
          element div-element
          result (get-class-list
                   element)]
      
      (is
        (= (str
             result)
           "test-class test-class2")
       )
      
     )
    
   ))

(deftest test-get-node-name
  (testing "Test get node name"
    
    (let [element nil
          result (get-node-name
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          element div-element
          result (get-node-name
                   element)]
      
      (is
        (= result
           "DIV")
       )
      
     )
    
   ))

(deftest test-add-class
  (testing "Test add class"
    
    (let [elements nil
          single-class nil
          result (add-class
                   elements
                   single-class)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          elements div-element
          single-class "test-class"]
      
      (add-class
        elements
        single-class)
      
      (is
        (= (get-attr
             elements
             "class")
           single-class)
       )
      
     )
    
   ))

(deftest test-remove-class
  (testing "Test remove class"
    
    (let [elements nil
          single-class nil
          result (remove-class
                   elements
                   single-class)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          void (.setAttribute
                 div-element
                 "class"
                 "test-class")
          elements div-element
          single-class "test-class"]
      
      (is
        (= (get-attr
             elements
             "class")
           single-class)
       )
      
      (remove-class
        elements
        single-class)
      
      (is
        (empty?
          (get-attr
            elements
            "class"))
       )
      
     )
    
   ))

(deftest test-contains-class
  (testing "Test contains class"
    
    (let [elements nil
          single-class nil
          result (contains-class
                   elements
                   single-class)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          void (.setAttribute
                 div-element
                 "class"
                 "test-class1 test-class2 test-class3")
          elements div-element
          single-class "test-class2"
          result (contains-class
                   elements
                   single-class)]
      
      (is
        (true?
          result)
       )
      
     )
    
    (let [div-element (.createElement
                        js/document
                        "div")
          void (.setAttribute
                 div-element
                 "class"
                 "test-class1 test-class2 test-class3")
          elements div-element
          single-class "test-class"
          result (contains-class
                   elements
                   single-class)]
      
      (is
        (false?
          result)
       )
      
     )
    
    (let [div-element-1 (.createElement
                          js/document
                          "div")
          void (.setAttribute
                 div-element-1
                 "class"
                 "test-class1 test-class2 test-class3")
          div-element-2 (.createElement
                          js/document
                          "div")
          void (.setAttribute
                 div-element-2
                 "class"
                 "test-class1 test-class2 test-class3")
          elements [div-element-1
                    div-element-2]
          single-class "test-class"
          result (contains-class
                   elements
                   single-class)]
      
      (is
        (false?
          result)
       )
      
     )
    
    (let [div-element-1 (.createElement
                          js/document
                          "div")
          void (.setAttribute
                 div-element-1
                 "class"
                 "test-class1 test-class2 test-class3")
          div-element-2 (.createElement
                          js/document
                          "div")
          void (.setAttribute
                 div-element-2
                 "class"
                 "test-class1 test-class2 test-class3")
          elements [div-element-1
                    div-element-2]
          single-class "test-class2"
          result (contains-class
                   elements
                   single-class)]
      
      (is
        (true?
          result)
       )
      
     )
    
   ))

(deftest test-element-exists
  (testing "Test element exists"
    
    (let [selector nil
          result (element-exists
                   selector)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [selector "body"
          result (element-exists
                   selector)]
      
      (is
        (not
          (empty?
            result))
       )
      
     )
    
   ))

(deftest test-fade-anim-append
  (testing "Test fade anim append"
    
    (let [delay-time nil
          style-id nil
          animation-name-class nil
          from-opacity nil
          to-opacity nil
          ;result (fade-anim-append
          ;         delay-time
          ;         style-id
          ;         animation-name-class
          ;         from-opacity
          ;         to-opacity)
                   ]
      
     )
    
   ))

(deftest test-fade-in-iteration
  (testing "Test fade in iteration"
    
    (let [ch-node nil
          sl-node nil
          anim-name-class nil
          style-id nil
          delay-time nil
          ;result (fade-in-iteration
          ;         ch-node
          ;         sl-node
          ;         anim-name-class
          ;         style-id
          ;         delay-time)
                   ]
      
     )
    
   ))

(deftest test-fade-in
  (testing "Test fade in"
    
    (let [selector nil
          html-content nil
          delay-time nil
          style-identification nil
          animation-name-class nil
          from-opacity nil
          to-opacity nil
          ;result (fade-in
          ;         selector
          ;         html-content
          ;         delay-time
          ;         style-identification
          ;         animation-name-class
          ;         from-opacity
          ;         to-opacity)
                   ]
      
     )
    
   ))

(deftest test-fade-out
  (testing "Test fade out"
    
    (let [selector nil
          delay-time nil
          style-identification nil
          only-content nil
          animation-name-class nil
          from-opacity nil
          to-opacity nil
          ;result (fade-out
          ;         selector
          ;         delay-time
          ;         style-identification
          ;         only-content
          ;         animation-name-class
          ;         from-opacity
          ;         to-opacity)
                   ]
      
     )
    
   ))

(deftest test-start-please-wait
  (testing "Test start please wait"
    
    (let [result (start-please-wait)]
      
      (is
        (not
          (empty?
            (element-exists
              "div.please-wait"))
         )
       )
      
      (remove-element
        "div.please-wait")
      
      (is
        (empty?
          (element-exists
            "div.please-wait"))
       )
      
     )
    
   ))

(deftest test-end-please-wait
  (testing "Test end please wait"
    
    (start-please-wait)
    
    (is
      (not
        (empty?
          (element-exists
            "div.please-wait"))
       )
     )
    
    (end-please-wait)
    
    (is
      (empty?
        (element-exists
          "div.please-wait"))
     )
    
   ))

(deftest test-update-progress-bar
  (testing "Test update progress bar"
    
    (let [progress-value nil
          color1 nil
          color2 nil
          result (update-progress-bar
                   progress-value
                   color1
                   color2)]
      
      (is
        (nil?
          result)
       )
      
      (is
        (nil?
          (query-selector
            ".progress-bar"))
       )
      
      (is
        (nil?
          (query-selector
            ".progress-bar-done-number"))
       )
      
     )
    
    (let [progress-bar-element (.createElement
                                 js/document
                                 "div")
          void (.setAttribute
                 progress-bar-element
                 "class"
                 "progress-bar")
          void (append-element
                 "body"
                 progress-bar-element)
          progress-bar-done-number-element (.createElement
                                             js/document
                                             "div")
          void (.setAttribute
                 progress-bar-done-number-element
                 "class"
                 "progress-bar-done-number")
          void (append-element
                 "body"
                 progress-bar-done-number-element)
          progress-value 20
          color1 "red"
          color2 "white"
          result (update-progress-bar
                   progress-value
                   color1
                   color2)]
      
      (let [progress-bar-el (query-selector
                              ".progress-bar")
            progress-bar-el-style (.getAttribute
                                    progress-bar-el
                                    "style")]
        
        (is
          (= progress-bar-el-style
             "background-image: linear-gradient(to right, red 0%, red 20%, white 20%, white 100%);")
         )
        
       )
      
      (is
        (= (get-inner-html
             ".progress-bar-done-number")
           "20%")
       )
      
      (set-inner-html
        "body"
        "")
      
     )
    
   ))

(deftest test-start-progress-bar
  (testing "Test start progress bar"
  
    (start-progress-bar)
    
    (is
      (not
        (empty?
          (element-exists
            "div.progress-bar-background"))
       )
     )
    
    (is
      (not
        (empty?
          (element-exists
            "div.progress-bar"))
       )
     )
    
    (is
      (not
        (empty?
          (element-exists
            "div.progress-bar-done-number"))
       )
     )
    
    (remove-element
      "div.progress-bar-background")
    
    (is
      (empty?
        (element-exists
          "div.progress-bar-background"))
     )
    
    (is
      (empty?
        (element-exists
          "div.progress-bar"))
     )
    
    (is
      (empty?
        (element-exists
          "div.progress-bar-done-number"))
     )
    
   ))

(deftest test-end-progress-bar
  (testing "Test end progress bar"
    
    (start-progress-bar)
    
    (is
      (not
        (empty?
          (element-exists
            "div.progress-bar-background"))
       )
     )
    
    (end-progress-bar)
    
    (is
      (empty?
        (element-exists
          "div.progress-bar-background"))
     )
    
   ))

(deftest test-is-checked?
  (testing "Test is checked?"
    
    (let [element nil
          result (is-checked?
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [checkbox-element (.createElement
                             js/document
                             "input")
          void (.setAttribute
                 checkbox-element
                 "type"
                 "checkbox")
          element checkbox-element
          result (is-checked?
                   element)]
      
      (is
        (false?
          result)
       )
      
     )
    
    (let [checkbox-element (.createElement
                             js/document
                             "input")
          void (.setAttribute
                 checkbox-element
                 "type"
                 "checkbox")
          void (.setAttribute
                 checkbox-element
                 "checked"
                 "checked")
          element checkbox-element
          result (is-checked?
                   element)]
      
      (is
        (true?
          result)
       )
      
     )
    
   ))

(deftest test-checked-value-with-index
  (testing "Test checked value with index"
    
    (let [radio-group-elements nil
          index nil
          result (checked-value-with-index
                   radio-group-elements
                   index)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [radio-element-1 (.createElement
                            js/document
                            "input")
          void (.setAttribute
                 radio-element-1
                 "type"
                 "radio")
          void (.setAttribute
                 radio-element-1
                 "name"
                 "radio-group")
          void (.setAttribute
                 radio-element-1
                 "value"
                 "value1")
          radio-element-2 (.createElement
                            js/document
                            "input")
          void (.setAttribute
                 radio-element-2
                 "type"
                 "radio")
          void (.setAttribute
                 radio-element-2
                 "name"
                 "radio-group")
          void (.setAttribute
                 radio-element-2
                 "value"
                 "value2")
          void (.setAttribute
                 radio-element-2
                 "checked"
                 "checked")
          radio-group-elements [radio-element-1
                                radio-element-2]
          index 0
          result (checked-value-with-index
                   radio-group-elements
                   index)]
      
      (is
        (= result
           "value2")
       )
      
     )
    
   ))

(deftest test-checked-value
  (testing "Test checked value"
    
    (let [radio-group-name nil
          result (checked-value
                   radio-group-name)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [radio-element-1 (.createElement
                            js/document
                            "input")
          void (.setAttribute
                 radio-element-1
                 "type"
                 "radio")
          void (.setAttribute
                 radio-element-1
                 "name"
                 "radio-group-name")
          void (.setAttribute
                 radio-element-1
                 "value"
                 "value1")
          void (append-element
                 "body"
                 radio-element-1)
          radio-element-2 (.createElement
                            js/document
                            "input")
          void (.setAttribute
                 radio-element-2
                 "type"
                 "radio")
          void (.setAttribute
                 radio-element-2
                 "name"
                 "radio-group-name")
          void (.setAttribute
                 radio-element-2
                 "value"
                 "value2")
          void (.setAttribute
                 radio-element-2
                 "checked"
                 "checked")
          void (append-element
                 "body"
                 radio-element-2)
          radio-group-name "radio-group-name"
          result (checked-value
                   radio-group-name)]
      
      (is
        (= result
           "value2")
       )
      
      (set-inner-html
        "body"
        "")
      
     )
    
   ))

(deftest test-cb-checked-values
  (testing "Test cb checked values"
    
    (let [checkbox-group-name nil
          result (cb-checked-values
                   checkbox-group-name)]
      
      (is
        (empty?
          result)
       )
      
     )
    
    (let [checkbox-element-1 (.createElement
                               js/document
                               "input")
          void (.setAttribute
                 checkbox-element-1
                 "type"
                 "checkbox")
          void (.setAttribute
                 checkbox-element-1
                 "name"
                 "checkbox-group-name")
          void (.setAttribute
                 checkbox-element-1
                 "value"
                 "value1")
          void (append-element
                 "body"
                 checkbox-element-1)
          checkbox-element-2 (.createElement
                               js/document
                               "input")
          void (.setAttribute
                 checkbox-element-2
                 "type"
                 "checkbox")
          void (.setAttribute
                 checkbox-element-2
                 "name"
                 "checkbox-group-name")
          void (.setAttribute
                 checkbox-element-2
                 "value"
                 "value2")
          void (.setAttribute
                 checkbox-element-2
                 "checked"
                 "checked")
          void (append-element
                 "body"
                 checkbox-element-2)
          checkbox-group-name "checkbox-group-name"
          result (cb-checked-values
                   checkbox-group-name)]
      
      (is
        (= result
           ["value2"])
       )
      
     )
    
   ))

(deftest test-fade-out-and-fade-in
  (testing "Test fade out and fade in"
    
    (let [selector nil
          anim-duration nil
          html-content nil
          ;result (fade-out-and-fade-in
          ;         selector
          ;         anim-duration
          ;         html-content)
                   ]
      
     )
    
   ))

(deftest test-find-event-type
  (testing "Test find event type"
    
    (let [event nil
          index nil
          result (find-event-type
                   event
                   index)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [event "click"
          index 0
          result (find-event-type
                   event
                   index)]
      
      (is
        (= result
           {:event-type "MouseEvent",
            :init-event-fn "initMouseEvent",
            :events #{"mousedown"
                      "mouseout"
                      "dblclick"
                      "click"
                      "mouseenter"
                      "mousemove"
                      "mouseup"
                      "contextmenu"
                      "mouseover"
                      "mouseleave"}})
       )
      
     )
    
   ))

(deftest test-init-event
  (testing "Test init event"
    
    (let [event nil
          result (init-event
                   event)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (let [event "click"
          result (init-event
                   event)]
      
      (is
        (= (str
             result)
           "[object MouseEvent]")
       )
      
     )
    
   ))

(deftest test-dispatch-event
  (testing "Test dispatch event"
    
    (let [event nil
          elem nil
          result (dispatch-event
                   event
                   elem)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (set-inner-html
      "body"
      "")
    
    (let [checkbox-element (.createElement
                             js/document
                             "input")
          void (.setAttribute
                 checkbox-element
                 "id"
                 "checkbox-element")
          void (.setAttribute
                 checkbox-element
                 "type"
                 "checkbox")
          void (append-element
                 "body"
                 checkbox-element)
          event "click"
          elem "#checkbox-elementa"]
      
      (dispatch-event
        event
        elem)
      
      (is
        (false?
          (is-checked?
            checkbox-element))
       )
      
     )
    
    (set-inner-html
      "body"
      "")
    
    (let [checkbox-element (.createElement
                             js/document
                             "input")
          void (.setAttribute
                 checkbox-element
                 "id"
                 "checkbox-element")
          void (.setAttribute
                 checkbox-element
                 "type"
                 "checkbox")
          void (append-element
                 "body"
                 checkbox-element)
          event "click"
          elem "#checkbox-element"]
      
      (dispatch-event
        event
        elem)
      
      (is
        (true?
          (is-checked?
            checkbox-element))
       )
      
     )
    
    (set-inner-html
      "body"
      "")
    
   ))

(deftest test-get-next-siblings
  (testing "Test get next siblings"
    
    (let [element nil
          result (get-next-siblings
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (set-inner-html
      "body"
      "")
    
    (let [previous-element (.createElement
                             js/document
                             "previous")
          void (append-element
                 "body"
                 previous-element)
          main-element (.createElement
                         js/document
                         "main")
          void (append-element
                 "body"
                 main-element)
          next-element (.createElement
                         js/document
                         "next")
          void (append-element
                 "body"
                 next-element)
          nextnext-element (.createElement
                             js/document
                             "nextnext")
          void (append-element
                 "body"
                 nextnext-element)
          element main-element
          result (get-next-siblings
                   element)]
      
      (is
        (= (count
             result)
           2)
       )
      
      (is
        (= (.-nodeName
             (get
               result
               0))
           "NEXT")
       )
      
      (is
        (= (.-nodeName
             (get
               result
               1))
           "NEXTNEXT")
       )
      
     )
    
    (set-inner-html
      "body"
      "")
    
   ))

(deftest test-get-previous-siblings
  (testing "Test get previous siblings"
    
    (let [element nil
          result (get-previous-siblings
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (set-inner-html
      "body"
      "")
    
    (let [previous-element (.createElement
                             js/document
                             "previous")
          void (append-element
                 "body"
                 previous-element)
          main-element (.createElement
                         js/document
                         "main")
          void (append-element
                 "body"
                 main-element)
          next-element (.createElement
                         js/document
                         "next")
          void (append-element
                 "body"
                 next-element)
          nextnext-element (.createElement
                             js/document
                             "nextnext")
          void (append-element
                 "body"
                 nextnext-element)
          element main-element
          result (get-previous-siblings
                   element)]
      
      (is
        (= (.-nodeName
             (get
               result
               0))
           "PREVIOUS")
       )
      
     )
    
   ))

(deftest test-get-all-siblings
  (testing "Test get all siblings"
    
    (let [element nil
          result (get-all-siblings
                   element)]
      
      (is
        (nil?
          result)
       )
      
     )
    
    (set-inner-html
      "body"
      "")
    
    (let [previous-element (.createElement
                             js/document
                             "previous")
          void (append-element
                 "body"
                 previous-element)
          main-element (.createElement
                         js/document
                         "main")
          void (append-element
                 "body"
                 main-element)
          next-element (.createElement
                         js/document
                         "next")
          void (append-element
                 "body"
                 next-element)
          nextnext-element (.createElement
                             js/document
                             "nextnext")
          void (append-element
                 "body"
                 nextnext-element)
          element main-element
          result (get-all-siblings
                   element)]
      
      (is
        (= (.-nodeName
             (get
               result
               0))
           "PREVIOUS")
       )
      
      (is
        (= (.-nodeName
             (get
               result
               1))
           "NEXT")
       )
      
      (is
        (= (.-nodeName
             (get
               result
               2))
           "NEXTNEXT")
       )
      
     )
    
   ))

