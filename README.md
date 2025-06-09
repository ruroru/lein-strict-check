[![Clojars Project](https://img.shields.io/clojars/v/org.clojars.jj/strict-check.svg)](https://clojars.org/org.clojars.jj/strict-check)
# strict-check

strict-check is a leiningen plugin that wraps lein check. It checks for reflection warnings in a project, and exits with non 0 status, if a reflection warnings were detected.

## Installation

Add to plugins list

```clojure 
[org.clojars.jj/strict-check "1.0.2"]
```

## Usage

```bash
lein strict-check ; echo $?
```

## License

Copyright © 2025 [ruroru](https://github.com/ruroru)

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
