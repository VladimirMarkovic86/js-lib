(ns js-lib.core
  (:require [htmlcss-lib.core :refer [gen stl anmtn slctr]]))

; document.getElementById("MyElement").classList.contains('MyClass')
; document.getElementById("MyElement").classList.toggle('MyClass')

(def anim-time
     100)

(def events
     [{:event-type "AnimationEvent" 	;For CSS animations
       :init-event-fn "initAnimationEvent"
       :events
         #{"animationend" 	;The event occurs when a CSS animation has completed
           "animationiteration" 	;The event occurs when a CSS animation is repeated
           "animationstart" 	;The event occurs when a CSS animation has started
           }}
      {:event-type "ClipboardEvent" 	;For modification of the clipboard
       :init-event-fn "initClipboardEvent"
       :events
         #{"copy" 	;The event occurs when the user copies the content of an element
           "cut" 	;The event occurs when the user cuts the content of an element
           "paste" 	;The event occurs when the user pastes some content in an element
           }}
      {:event-type "DragEvent" 	;For drag and drop interaction
       :init-event-fn "initDragEvent"
       :events
         #{"drag" 	;The event occurs when an element is being dragged
           "dragend" 	;The event occurs when the user has finished dragging an element
           "dragenter" 	;The event occurs when the dragged element enters the drop target
           "dragleave" 	;The event occurs when the dragged element leaves the drop target
           "dragover" 	;The event occurs when the dragged element is over the drop target
           "dragstart" 	;The event occurs when the user starts to drag an element
           "drop" 	;The event occurs when the dragged element is dropped on the
                     ;drop target
           }}
      {:event-type "FocusEvent" 	;For focus-related events
       :init-event-fn "initFocusEvent"
       :events
         #{"blur" 	;The event occurs when an element loses focus
           "focus" 	;The event occurs when an element gets focus
           "focusin" 	;The event occurs when an element is about to get focus
           "focusout" 	;The event occurs when an element is about to lose focus
           }}
      {:event-type "HashChangeEvent" 	;For changes in the anchor part of the URL
       :init-event-fn "initHashChangeEvent"
       :events
         #{"hashchange" 	;The event occurs when there has been changes to the anchor
                           ;part of a URL
           }}
      {:event-type "InputEvent" 	;For user input
       :init-event-fn "initInputEvent"
       :events
         #{"input" 	;The event occurs when an element gets user input
           }}
      {:event-type "KeyboardEvent" 	;For keyboard interaction
       :init-event-fn "initKeyboardEvent"
       :events
         #{"keydown" 	;The event occurs when the user is pressing a key
           "keypress" 	;The event occurs when the user presses a key
           "keyup" 	;The event occurs when the user releases a key
           }}
      {:event-type "MouseEvent" 	;For mouse interaction
       :init-event-fn "initMouseEvent"
       :events
         #{"click" 	;The event occurs when the user clicks on an element
           "contextmenu" 	;The event occurs when the user right-clicks on an element
                            ;to open a context menu
           "dblclick" 	;The event occurs when the user double-clicks on an element
           "mousedown" 	;The event occurs when the user presses a mouse button over
                          ;an element
           "mouseenter" 	;The event occurs when the pointer is moved onto an element
           "mouseleave" 	;The event occurs when the pointer is moved out of an element
           "mousemove" 	;The event occurs when the pointer is moving while it is over
                          ;an element
           "mouseout" 	;The event occurs when a user moves the mouse pointer out of an
                         ;element, or out of one of its children
           "mouseover" 	;The event occurs when the pointer is moved onto an element, or
                          ;onto one of its children
           "mouseup" 	;The event occurs when a user releases a mouse button over
                      ;an element
           }}
      {:event-type "PageTransitionEvent" 	;For navigating to, and away from, web pages
       :init-event-fn "initPageTransitionEvent"
       :events
         #{"pagehide" 	;The event occurs when the user navigates away from a webpage
           "pageshow" 	;The event occurs when the user navigates to a webpage
           }}
      {:event-type "PopStateEvent" 	;For changes in the history entry
       :init-event-fn "initPopStateEvent"
       :events
         #{"popstate" 	;The event occurs when the window's history changes
           }}
      {:event-type "ProgressEvent" 	;For the progress of loading external resources
       :init-event-fn "initProgressEvent"
       :events
         #{"error" 	;The event occurs when an error occurs while loading an external file
           "loadstart" 	;The event occurs when the browser starts looking for the
                        ;specified media
           }}
      {:event-type "StorageEvent" 	;For changes in the window's storage area.
       :init-event-fn "initStorageEvent"
       :events
         #{"storage" 	;The event occurs when a Web Storage area is updated
           }}
      {:event-type "TouchEvent" 	;For touch interaction
       :init-event-fn "initTouchEvent"
       :events
         #{"touchcancel" 	;The event occurs when the touch is interrupted
           "touchend" 	;The event occurs when a finger is removed from a touch screen
           "touchmove" 	;The event occurs when a finger is dragged across the screen
           "touchstart" 	;The event occurs when a finger is placed on a touch screen
           }}
      {:event-type "TransitionEvent" 	;For CSS transitions
       :init-event-fn "initTransitionEvent"
       :events
         #{"transitionend" 	;The event occurs when a CSS transition has completed
           }}
      {:event-type "UiEvent" 	;For user interface interaction
       :init-event-fn "initUiEvent"
       :events
         #{"abort" 	;The event occurs when the loading of a media is aborted
           "beforeunload" 	;The event occurs before the document is about to be unloaded
           "error" 	;The event occurs when an error occurred during the loading of a
                    ;media file
           "load" 	;The event occurs when an object has loaded
           "resize" 	;The event occurs when the document view is resized
           "scroll" 	;The event occurs when an element's scrollbar is being scrolled
           "select" 	;The event occurs after the user selects some text (for <input>
                     ;and <textarea>)
           "unload" 	;The event occurs once a page has unloaded (for <body>)
           }}
      {:event-type "WheelEvent" 	;For mousewheel interaction
       :init-event-fn "initWheelEvent"
       :events
         #{"onwheel" 	;The event occurs when the mouse wheel rolls up or down over
                      ;an element
           }}
      {:event-type "Event"
       :init-event-fn "initEvent"
       :events
         #{"abort" 	;The event occurs when the loading of a media is aborted
           "afterprint" 	;The event occurs when a page has started printing
           "beforeprint" 	;The event occurs when a page is about to be printed
           "beforeunload" 	;The event occurs before the document is about to be unloaded
           "canplay" 	;The event occurs when the browser can start playing the
                      ;media (when it has buffered enough to begin)
           "canplaythrough" 	;The event occurs when the browser can play through
                             ;the media without stopping for buffering
           "change" 	;The event occurs when the content of a form element, the selection,
                     ; or the checked state have changed (for <input>, <select>,
                     ; and <textarea>)
           "error" 	;The event occurs when an error occurs while loading an external file
           "fullscreenchange" 	;The event occurs when an element is displayed
                               ;in fullscreen mode
           "fullscreenerror" 	;The event occurs when an element can not be displayed
                              ;in fullscreen mode
           "input" 	;The event occurs when an element gets user input
           "invalid" 	;The event occurs when an element is invalid
           "load" 	;The event occurs when an object has loaded
           "loadeddata" 	;The event occurs when media data is loaded
           "loadedmetadata" 	;The event occurs when meta data (like dimensions
                             ;and duration) are loaded
           "message" 	;The event occurs when a message is received through the event source
           "offline" 	;The event occurs when the browser starts to work offline
           "online" 	;The event occurs when the browser starts to work online
           "open" 	;The event occurs when a connection with the event source is opened
           "pause" 	;The event occurs when the media is paused either by the user
                    ;or programmatically
           "play" 	;The event occurs when the media has been started or is no longer paused
           "playing" 	;The event occurs when the media is playing after having been
                      ;paused or stopped for buffering
           "progress" 	;The event occurs when the browser is in the process of
                       ;getting the media data (downloading the media)
           "ratechange" 	;The event occurs when the playing speed of the media is changed
           "resize" 	;The event occurs when the document view is resized
           "reset" 	;The event occurs when a form is reset
           "scroll" 	;The event occurs when an element's scrollbar is being scrolled
           "search" 	;The event occurs when the user writes something in a search
                     ;field (for <input="search">)
           "seeked" 	;The event occurs when the user is finished moving/skipping
                     ;to a new position in the media
           "seeking" 	;The event occurs when the user starts moving/skipping to a
                      ;new position in the media
           "select" 	;The event occurs after the user selects some text (for <input>
                     ;and <textarea>)
           "show" 	;The event occurs when a <menu> element is shown as a context menu
           "stalled" 	;The event occurs when the browser is trying to get media data,
                      ;but data is not available
           "submit" 	;The event occurs when a form is submitted
           "suspend" 	;The event occurs when the browser is intentionally not getting
                      ;media data
           "timeupdate" 	;The event occurs when the playing position has changed
                         ;(like when the user fast forwards to a different point in
                         ;the media)
           "toggle" 	;The event occurs when the user opens or closes the <details> element
           "unload" 	;The event occurs once a page has unloaded (for <body>)
           "waiting" 	;The event occurs when the media has paused but is expected
                      ;to resume (like when the media pauses to buffer more data)
           }}])

(defn get-url
  "Retrieve URL from address bar"
  []
  (aget js/document "URL"))

(defn html?
  "Is data fn parameter HTML element"
  [data]
  (when data
    (when-let [data-type-name (aget
                                (type data)
                                "name")]
      (> (.indexOf
           data-type-name
           "HTML")
         -1))
   ))

(defn convert-to-vector
  "Convert html NodeList object to clojure vector"
  [node-list]
  (let [result            (atom [])
        node-list-length  (alength node-list)]
    (doseq [node-index (range 0 node-list-length)]
      (swap! result conj (aget node-list node-index))
     )
    @result))

(defn query-selector
  "Select first element of what css selector fetches from document
   returns single element (html node)"
  [selector]
  (if (string? selector)
    (.querySelector
      js/document
      selector)
    (when (html? selector)
      selector))
 )

(defn query-selector-all
  "Select all element of what css selector fetches from document
   returns collection of elements (html nodes)"
  [selector]
  (convert-to-vector
    (.querySelectorAll
      js/document
      selector))
 )

(defn query-selector-on-element
  "Select first element of what css selector fetches from element param
   returns single element (html node)"
  [element
   selector]
  (let [result (atom nil)]
    (when (and (string? element)
               (string? selector))
      (let [element (.querySelector
                      js/document
                      element)]
        (reset!
          result
          (.querySelector
            element
            selector))
       ))
    (when (and (html? element)
               (string? selector))
      (reset!
        result
        (.querySelector
          element
          selector))
     )
    (when (html? selector)
      (reset!
        result
        selector))
    @result))

(defn query-selector-all-on-element
  "Select all element of what css selector fetches from element param
   returns collection of elements (html nodes)"
  [element
   selector]
  (let [result (atom [])]
    (when (and (string? element)
               (string? selector))
      (let [elements (convert-to-vector
                       (.querySelectorAll
                         js/document
                         element))]
        (doseq [element elements]
          (swap!
            result
            (fn [atom-value
                 collection]
              (apply
                conj
                atom-value
                collection))
            (convert-to-vector
              (.querySelectorAll
                element
                selector))
           ))
       ))
    (when (and (html? element)
               (string? selector))
      (reset!
        result
        (convert-to-vector
          (.querySelectorAll
            element
            selector))
       ))
    @result))

(defn get-by-id
  "Select element by id
   returns single element (html node)"
  [element-id]
  (.getElementById
    js/document
    element-id))

(defn get-by-class
  "Select elements by class
   returns collection of elements (html nodes)"
  [element-class]
  (.getElementsByClassName
    js/document
    element-class))

(defn xpath
  "(xpath '//div[contains(text(), 'Searched text')]')"
  [selector]
  (let [iterator (.evaluate
                   js/document
                   selector
                   js/document
                   nil
                   (aget
                     js/XPathResult
                     "UNORDERED_NODE_ITERATOR_TYPE")
                   nil)
        this-node (.iterateNext
                    iterator)]
    this-node))

(defn get-child-nodes
  "Fetch child nodes of element param"
  [element]
  (convert-to-vector
    (aget
      element
      "childNodes"))
 )

(defn parse-html
  "Parses html from string"
  [html-content]
  (let [parser (js/DOMParser.)
        html-dom-content (.parseFromString
                           parser
                           html-content
                           "text/html")
        html-element (first (get-child-nodes html-dom-content))
        head-element (first (get-child-nodes html-element))
        body-element (first (rest (get-child-nodes html-element)))
        concrete-head-elements (get-child-nodes head-element)
        concrete-body-elements (get-child-nodes body-element)]
    (if (= (count concrete-body-elements) 0)
      concrete-head-elements
      concrete-body-elements))
 )

(defn determine-param-type
  "Determine if param is string or html type of object"
  [exec-fn
   param]
  (if (string? param)
    (exec-fn param)
    (if (html? param)
      param
      (if (vector? param)
        param
        []))
   ))

(defn is-valid?
  "Returns elements value"
  [element]
  (let [element (determine-param-type
                  query-selector
                  element)]
    (aget
      (aget
        element
        "validity")
      "valid"))
 )

(defn get-value
  "Returns elements value"
  [element]
  (let [element (determine-param-type
                  query-selector
                  element)]
    (aget element "value"))
 )

(defn get-value-as-number
  "Returns elements value"
  [element]
  (let [element (determine-param-type
                  query-selector
                  element)]
    (aget element "valueAsNumber"))
 )

(defn get-value-as-date
  "Returns elements value"
  [element]
  (let [element (determine-param-type
                  query-selector
                  element)]
    (aget element "valueAsDate"))
 )

(defn set-value
  "Sets element's value"
  [element
   new-value]
  (let [element (determine-param-type
                  query-selector
                  element)]
    (aset element "value" new-value))
 )

(defn get-checked
  "Returns elements checked"
  [element]
  (let [element (determine-param-type
                  query-selector
                  element)]
    (aget element "checked"))
 )

(defn set-checked
  "Sets element's checked"
  [element
   new-value]
  (let [element (determine-param-type
                  query-selector
                  element)]
    (aset element "checked" new-value))
 )

(defn get-src
  "Returns elements src attribute value"
  [element]
  (let [element (determine-param-type
                  query-selector
                  element)]
    (aget element "src"))
 )

(defn set-src
  "Sets element's src"
  [element
   new-value]
  (let [element (determine-param-type
                  query-selector
                  element)]
    (aset element "src" new-value))
 )

(defn get-type
  "Returns elements type"
  [element]
  (aget element "type"))

(defn get-parent
  "Get parentNode property"
  [element]
  (aget element "parentNode"))

(defn ancestor
  "Finds ancestor of an element at particular level"
  [element
   ancestor-level]
  (reduce
    (fn [acc
         elem]
      (get-parent
        acc))
    element
    (range
      ancestor-level))
 )

(defn replace-single
  "Replace first occurrence of string in first parameter"
  [str-content
   replace-this
   replace-with]
  (.replace
    str-content
    replace-this
    replace-with))

(defn replace-all
  "Replace every occurance of supplied string"
  [str-content
   replace-this
   replace-with]
  (let [result (atom str-content)]
    (if (< -1 (.indexOf @result replace-this))
      (recur
        (reset!
          result
          (.replace str-content
                    replace-this
                    replace-with))
        replace-this
        replace-with)
      @result))
 )

(defn empty-nodes
  "Empty elements feched by selector"
  [selector]
  (let [selected-nodes (query-selector-all
                         selector)]
    (doseq [sl-node selected-nodes]
      (let [child-nodes (get-child-nodes
                          sl-node)]
        (doseq [ch-node child-nodes]
          (.removeChild
            sl-node
            ch-node))
       ))
   ))

(defn get-inner-html
  "Get innerHTML property of first element feched by selector"
  [element]
  (let [sl-node (determine-param-type
                  query-selector element)]
    (aget sl-node "innerHTML"))
 )

(defn set-inner-html
  "Set html-content as innerHTML property of elements feched by selector"
  [selector
   html-content]
  (let [selected-nodes (determine-param-type query-selector-all selector)]
    (if (vector? selected-nodes)
      (doseq [sl-node selected-nodes]
        (aset sl-node "innerHTML" html-content))
      (aset selected-nodes "innerHTML" html-content))
   ))

(defn get-outer-html
  "Get outerHTML property of first element feched by selector"
  [selector]
  (let [sl-node (query-selector selector)]
    (aget sl-node "outerHTML"))
  )

(defn set-outer-html
  "Set html-content as outerHTML property of elements feched by selector"
  [selector
   html-content]
  (let [selected-nodes (query-selector-all
                         selector)]
    (doseq [sl-node selected-nodes]
      (aset sl-node "outerHTML" html-content))
   ))

; Implement multi select

(defn get-selected-options
  "Get values of property selectedOptions and pack them in vector"
  [element]
  (let [element (determine-param-type
                  query-selector
                  element)
        slctd-optns (convert-to-vector
                      (aget element "selectedOptions"))
        slctd-optns-vec (atom [])]
   (doseq [slctd-optn slctd-optns]
     (let [sl-attrs (atom {})]
       (doseq [i (range
                   (aget
                     (aget
                       slctd-optn
                       "attributes")
                     "length"))]
         (let [attr (aget
                      (aget
                        slctd-optn
                        "attributes")
                      i)]
           (swap!
             sl-attrs
             conj
             {(keyword (aget attr "name")) (aget attr "value")}))
        )
       (swap!
         sl-attrs
         conj
         {(keyword "label") (aget slctd-optn "innerHTML")})
       (swap!
         slctd-optns-vec
         conj
         @sl-attrs))
    )
   (when (not-empty @slctd-optns-vec)
     (if (= (count @slctd-optns-vec)
            1)
       (first @slctd-optns-vec)
       @slctd-optns-vec))
   ))

(defn- add-fn-to-event
  "Add function to event for particular element"
  [element
   event-type
   event-function
   & [fn-params]]
  (let [event-funcs (str event-type "-funcs")]
    (aset
      element
      event-funcs
      (assoc (aget element event-funcs)
             (str event-function)
             #(event-function fn-params element))
     )
    (when-not (aget element event-type)
      (aset
        element
        event-type
        #(doseq [func (into
                        []
                        (map
                          val
                          (aget
                            element
                            event-funcs))
                       )]
           (func))
       ))
   ))

(defn event
  "Bind function to event on elements fetched by selector
  
   (event element \"onclick\" event-function [1 2 3])
   
   element         Represents selector or html element
   event-type      Represents html event, like onclick, onload...
   event-function  Represents function name
   [fn-params]     Represents vector that will be passed to event function"
  [element
   event-type
   event-function
   & [fn-params]]
  (let [selected-nodes (determine-param-type
                         query-selector-all
                         element)]
    (if (vector? selected-nodes)
      (doseq [sl-node selected-nodes]
        (add-fn-to-event
          sl-node
          event-type
          event-function
          fn-params))
      (add-fn-to-event
        selected-nodes
        event-type
        event-function
        fn-params))
   ))

(defn- remove-fn-from-event
  "Remove particular function from executing after an event has occurred"
  [element
   event-type
   event-function]
  (let [event-funcs (str event-type "-funcs")]
    (aset
      element
      event-funcs
      (dissoc (aget element event-funcs)
              (str event-function))
     )
    (when (empty? (aget element event-funcs))
      (aset element
            event-type
            nil)
      (aset element
            event-funcs
            nil))
   ))

(defn remove-event
  "Remove function from event on elements fetched by selector
  
   (remove-event element \"onclick\" event-function))
   
   element         Represents selector or html element
   event-type      Represents html event, like onclick, onload...
   event-function  Represents function name"
  [element
   event-type
   event-function]
  (let [selected-nodes (determine-param-type
                         query-selector-all
                         element)]
    (if (vector? selected-nodes)
      (doseq [sl-node selected-nodes]
        (remove-fn-from-event
          sl-node
          event-type
          event-function))
      (remove-fn-from-event
        element
        event-type
        event-function))
   ))

(defn- remove-all-fns-from-event
  "Remove all functions from executing after an event has occurred on particular element"
  [element
   event-type]
  (let [event-funcs (str event-type "-funcs")]
    (aset
      element
      event-type
      nil)
    (aset
      element
      event-funcs
      nil))
 )

(defn remove-all-event
  "Remove all functions from executing after an event has occurred on particular element/s"
  [element
   event-type]
  (let [selected-nodes (determine-param-type
                         query-selector-all
                         element)]
    (if (vector? selected-nodes)
      (doseq [sl-node selected-nodes]
        (remove-all-fns-from-event
          sl-node
          event-type))
      (remove-all-fns-from-event
        element
        event-type))
   ))

(defn prepend-element
  "Prepend html string in elements fetched by selector"
  [selector
   html-content]
  (let [selected-nodes (query-selector-all
                         selector)
        child-nodes (determine-param-type
                      parse-html
                      html-content)]
    (doseq [sl-node selected-nodes]
      (when (vector? child-nodes)
        (doseq [ch-node child-nodes]
          (let [insert-before-this (first (get-child-nodes sl-node))]
            (.insertBefore
              sl-node
              ch-node
              insert-before-this))
         ))
      (when (html? child-nodes)
        (let [insert-before-this (first (get-child-nodes sl-node))]
          (.insertBefore
            sl-node
            child-nodes
            insert-before-this))
       ))
   ))

(defn append-element
  "Append html string in elements fetched by selector"
  [selector
   html-content]
  (let [selected-nodes (determine-param-type
                         query-selector-all
                         selector)
        child-nodes (determine-param-type
                      parse-html
                      html-content)]
    (if (vector? selected-nodes)
      (doseq [sl-node selected-nodes]
        (if (vector? child-nodes)
          (doseq [ch-node child-nodes]
            (.appendChild
              sl-node
              ch-node))
          (.appendChild
            sl-node
            child-nodes))
       )
      (if (vector? child-nodes)
        (doseq [ch-node child-nodes]
          (.appendChild
            selected-nodes
            ch-node))
        (.appendChild
          selected-nodes
          child-nodes))
     ))
 )

(defn content
  "Empty fetched elements by selector and append html string"
  [selector
   html-content]
  (empty-nodes
    selector)
  (append-element
    selector
    html-content))

(defn remove-element
  "Remove elements fetched by selector"
  [selector]
  (let [selected-nodes (determine-param-type
                         query-selector-all
                         selector)]
    (when (vector? selected-nodes)
      (doseq [sl-node selected-nodes]
        (.removeChild
          (get-parent
            sl-node)
          sl-node))
     )
    (when (html? selected-nodes)
      (.removeChild
        (get-parent
          selected-nodes)
        selected-nodes))
   ))

(defn remove-element-content
  "Remove content from elements fetched by selector"
  [selector]
  (let [selected-nodes (query-selector-all
                         selector)]
    (doseq [sl-node selected-nodes]
      (aset sl-node "innerHTML" ""))
   ))

(defn remove-element-from-element
  "Remove elements fetched by selector"
  [element
   selector]
  (let [element-nodes (determine-param-type
                        query-selector-all
                        element)]
   (doseq [element-node element-nodes]
     (let [selected-nodes (query-selector-all-on-element
                            element-node
                            selector)]
       (doseq [sl-node selected-nodes]
         (.removeChild
           (get-parent
             sl-node)
           sl-node))
      ))
   ))

(defn timeout
  "Delay function execution by milliseconds"
  [execute-fn
   delay-time]
  (js/setTimeout
    execute-fn
    delay-time))

(defn get-attr
  "Get attribute's value of element"
  [element
   attr-name]
  (.getAttribute
    element
    attr-name))

(defn set-attr
  "Set attribute's value of element"
  [element
   attr-name
   value]
  (.setAttribute
    element
    attr-name
    value))

(defn set-attrs
  "Set attribute's value of elements collection"
  [elements
   attr-name
   value]
  (doseq [element elements]
    (set-attr
      element
      attr-name
      value))
 )

(defn get-class-list
  "Get classList property"
  [element]
  (aget element "classList"))

(defn get-node-name
  "Get nodeName property"
  [element]
  (aget element "nodeName"))

(defn add-class
  "Add class to elements collection"
  [elements
   single-class]
  (let [elements (determine-param-type
                   query-selector-all
                   elements)]
    (when (vector? elements)
      (doseq [element elements]
        (.add
          (get-class-list
            element)
          single-class))
     )
    (when (html? elements)
      (.add
        (get-class-list
          elements)
        single-class))
   ))

(defn remove-class
  "Remove class from elements collection"
  [elements
   single-class]
  (let [elements (determine-param-type
                   query-selector-all
                   elements)]
    
    (when (vector? elements)
      (doseq [element elements]
        (.remove
          (get-class-list
            element)
          single-class))
     )
    (when (html? elements)
      (.remove
        (get-class-list
          elements)
        single-class))
   ))

(defn element-exists
  "Check if fade in style exists in DOM"
  [selector]
  (let [selected-elements (query-selector-all
                            selector)]
    (not (empty? selected-elements))
   ))

(defn- fade-anim-append
  "Append fade in style to head"
  [delay-time
   style-id
   animation-name-class
   from-opacity
   to-opacity]
  (when-not (element-exists (str "style#" style-id))
    (let [delay-time-as-string (str (float (/ delay-time 1000))
                                )
          final-element (gen
                          (stl
                            style-id
                            (anmtn
                             animation-name-class
                             {:opacity (str from-opacity)}
                             {:opacity (str to-opacity)})
                            (slctr
                              (str "." animation-name-class)
                              {:animation (str animation-name-class
                                               " "
                                               delay-time-as-string
                                               "s")}))
                          "style")]
      (append-element
        "body div.styles"
        final-element))
   ))

(defn- fade-in-iteration
  "Set class on element to fade in, and and then append element to selected node"
  [ch-node
   sl-node
   anim-name-class
   style-id
   delay-time]
  (let [node-name (get-node-name
                    ch-node)
        insert-before-this (query-selector-on-element
                             sl-node
                             "div.scripts")]
    (when-not (= node-name
                 "#text")
      (add-class ch-node anim-name-class)
      (.insertBefore sl-node ch-node insert-before-this)
      (timeout
        #(do (remove-class ch-node anim-name-class)
             (set-outer-html
               (str "style#" style-id)
               "")
             (set-inner-html 
               "div.styles"
               (replace-all
                 (get-inner-html
                   "div.styles")
                 "\n"
                 ""))
          )
        delay-time))
   ))

(defn fade-in
  "Fade in html string content in elements fetched by selector during delay time
  
  parameters:
   selector              query document with this selector
   html-content          String or HTMLObject that will be inserted
   delay-time            fade-in duration time
   
   style-identification  id of style html element that will be generated and appended
   animation-name-class  generating style html element, this parameter will be used for
                           animation and class name
   from-opacity          number from 0.0 to 1.0 that will specify starting opacity of
                           fading element
   to-opacity            number from 0.0 to 1.0 that will specify ending opacity of
                           fading element"
  [selector
   html-content
   ^int delay-time
   & [style-identification
      animation-name-class
      from-opacity
      to-opacity]]
  (let [style-id (str style-identification "fade-in")
        anim-name-class (str animation-name-class "fade-in")
        from-opac (or from-opacity
                      0)
        to-opac (or to-opacity
                    1)]
    (fade-anim-append
      delay-time
      style-id
      anim-name-class
      from-opac
      to-opac)
    (let [selected-nodes (query-selector-all
                           selector)
          child-nodes (determine-param-type
                        parse-html
                        html-content)]
      (doseq [sl-node selected-nodes]
        (if (vector? child-nodes)
          (doseq [ch-node child-nodes]
            (fade-in-iteration
              ch-node
              sl-node
              anim-name-class
              style-id delay-time))
          (fade-in-iteration
            child-nodes
            sl-node
            anim-name-class
            style-id delay-time))
       ))
   ))

(defn fade-out
  "Fade out html string content in elements fetched by selector during delay time
  
  parameters:
   selector              query document with this selector
   delay-time            fade-out duration time
   
   style-identification  id of style html element that will be generated and appended
   only-content          when removing faded element
                           true for only for content to be remove
                           false for element, fetched with selector, to be removed
   animation-name-class  generating style html element, this parameter will be used for
                           animation and class name
   from-opacity          number from 0.0 to 1.0 that will specify starting opacity of
                           fading element
   to-opacity            number from 0.0 to 1.0 that will specify ending opacity of
                           fading element"
  [selector
   ^int delay-time
   & [style-identification
      only-content
      animation-name-class
      from-opacity
      to-opacity]]
  (let [style-id (str style-identification "fade-out")
        anim-name-class (str animation-name-class "fade-out")
        from-opac (or from-opacity
                      1)
        to-opac (or to-opacity
                    0)]
    (fade-anim-append
      delay-time
      style-id
      anim-name-class
      from-opac
      to-opac)
    (let [selected-nodes   (query-selector-all selector)]
      (doseq [sl-node selected-nodes]
        (let [child-nodes    (get-child-nodes sl-node)]
          (if only-content
            (doseq [ch-node child-nodes]
              (let [node-name  (get-node-name ch-node)]
                (when-not (= "#text" node-name)
                 (remove-class
                   ch-node
                   (str animation-name-class "fade-in"))
                 (add-class
                   ch-node
                   anim-name-class))
               ))
            (add-class
              sl-node
              anim-name-class))
         ))
     )
    (timeout
      #(do
         (if only-content
           (set-outer-html (str "." anim-name-class) "")
           (set-outer-html selector ""))
         (set-outer-html
           (str "style#" style-id)
           "")
         (set-inner-html 
           "div.styles"
           (replace-all
             (get-inner-html
               "div.styles")
             "\n"
             ""))
        )
      delay-time))
 )

(defn start-please-wait
  "Display please wait message"
  []
  (.blur
    (.-activeElement
      js/document))
  (append-element
    "body"
    "<div class=\"please-wait\" ></div>"))

(defn end-please-wait
  "Hide please wait message"
  []
  (remove-element
    "div.please-wait"))

(defn update-progress-bar
  "Update percentage of progress bar"
  [progress-value]
  (let [progress-bar-done (query-selector
                            ".progress-bar")
        progress-bar-done-number (query-selector
                                   ".progress-bar-done-number")]
   (when-not (nil? progress-bar-done)
     (set-attr
       progress-bar-done
       "style"
       (str
         "background-image: "
          "linear-gradient(to right, "
           "red 0%, "
           "red " progress-value "%, "
           "white " progress-value "%, "
           "white 100%);"))
    )
   (when-not (nil? progress-bar-done-number)
     (set-inner-html
       progress-bar-done-number
       (str
         progress-value
         "%"))
    ))
 )

(defn start-progress-bar
  "Display progress bar message"
  []
  (.blur
    (.-activeElement
      js/document))
  (start-please-wait)
  (append-element
    "body"
    (str
      "<div class=\"progress-bar-background\" >"
       "<div class=\"progress-bar\" >"
        "<div class=\"progress-bar-done-number\" >"
          "0%"
        "</div>"
       "</div>"
      "</div>"
      ))
 )

(defn end-progress-bar
  "Hide progress bar message"
  []
  (remove-element
    "div.progress-bar-background")
  (end-please-wait))

(defn is-checked?
  "Return value of checked property from html element"
  [element]
  (aget element "checked"))

(defn checked-value-with-index
  "Iterate through html radio elements and check if any of them is checked,
   if html radio element is checked, return it's value"
  [radio-group-elements
   index]
  (when (< index
           (count
             radio-group-elements))
    (let [radio-group-element (radio-group-elements
                                index)]
      (if (is-checked? radio-group-element)
        (get-value
          radio-group-element)
        (recur
          radio-group-elements
          (inc index))
       ))
   ))

(defn checked-value
  "Query dom for input html radio group by name and find if the choice was made"
  [radio-group-name]
  (let [radio-group-elements (query-selector-all
                               (str
                                 "input[name='"
                                 radio-group-name
                                 "']"))]
    (checked-value-with-index
      radio-group-elements
      0))
 )

(defn cb-checked-values
  "Checks which values are checked in checkbox group and packs them in vector"
  [checkbox-group-name]
  (let [checkbox-group-elements (query-selector-all
                                  (str
                                    "input[name='"
                                    checkbox-group-name
                                    "']"))
        checked-values (atom [])]
    (doseq [checkbox-el checkbox-group-elements]
      (when (is-checked? checkbox-el)
        (swap!
          checked-values
          conj
          (get-value
            checkbox-el))
       ))
    @checked-values))

(defn fade-out-and-fade-in
  "Automation fade in fade out of an element"
  [selector
   anim-duration
   html-content]
  (fade-out
    selector
    anim-duration
    "fade-out-and-fade-in"
    true)
  (timeout
    #(fade-in
       selector
       html-content
       anim-duration)
    anim-duration))

(defn find-event-type
  "Find event type of predefined types"
  [event
   index]
  (when (< index
           (count events))
    (let [event-type-obj (get events index)
          {events :events} event-type-obj]
      (if (contains?
            events
            event)
        event-type-obj
        (recur
          event
          (inc
            index))
       ))
   ))

(defn init-event
  "Initialize event for particular event object"
  [event
   & [window-obj]]
  (let [return-event (atom nil)]
    (when (instance?
            js/Event
            event)
      (reset!
        return-event
        event))
    (when (string? event)
      (let [window-obj (or window-obj
                           js/window)
            {event-type :event-type
             init-event-fn :init-event-fn} (find-event-type
                                             event
                                             0)
            event-obj (.createEvent
                        (aget
                          window-obj
                          "document")
                        event-type)]
        (js-invoke
          event-obj
          init-event-fn
          event
          true
          true)
        (reset!
          return-event
          event-obj))
     )
    @return-event))

(defn dispatch-event
  ""
  [event
   elem
   & [window-obj]]
  (let [window-obj (or window-obj
                       js/window)
        elem (if (string?
                   elem)
               (query-selector-on-element
                 (aget
                   window-obj
                   "document")
                 elem)
               elem)
        event-obj (init-event
                    event
                    window-obj)]
    (.dispatchEvent
      elem
      event-obj))
 )

