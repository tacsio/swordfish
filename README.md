```
  ____                       _ _____ _     _       __    ______
 / ___|_      _____  _ __ __| |  ___(_)___| |__    \ \  / / /\ \
 \___ \ \ /\ / / _ \| '__/ _` | |_  | / __| '_ \    \ \/ / /  \ \
  ___) \ V  V / (_) | | | (_| |  _| | \__ \ | | |   / /\ \ \  / /
 |____/ \_/\_/ \___/|_|  \__,_|_|   |_|___/_| |_|  /_/  \_\_\/_/

```
[![Build Status][Status]](https://travis-ci.org/tacsio/swordfish)
[![GitHub issues][Issues]](https://github.com/tacsio/swordfish/issues)
[![GitHub license][License]](https://github.com/tacsio/swordfish/blob/master/LICENSE)

![Logo][Logo]

Sample spring boot application configured with cucumber to exercise integration tests
and [behavior-driven development][bdd]

Demo Version
=========
We deploye an simple Progressive Web App on [Heroku][swordfish]

Team
=========
- Hially Sá - [@hiallyrs](https://github.com/hiallyrs)
- Mariane Mariz - [@mariemariz](https://github.com/mariemariz)
- Tarcisio Coutinho - [@tacsio](https://github.com/tacsio)


Dependencies
=========

- Java 8
- Bower 1.7+

Building
=========

For dev environment with eclipse:

```sh
bower install
./gradlew eclipse
```

Running Tests
=========

```sh
bower install
./gradlew clean check
```

License
=========
MIT License

Copyright (c) 2017 Hialy Sá, Mariane Mariz & Tarcisio Coutinho

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


Contributing
============

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Added some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request



[Logo]: http://elnur.pro/images/bdd-cycle-around-tdd-cycles.png
[License]: https://img.shields.io/github/license/tacsio/swordfish.svg
[Issues]: https://img.shields.io/github/issues/tacsio/swordfish.svg
[Status]: https://travis-ci.org/tacsio/swordfish.svg?branch=master

[bdd]: https://en.wikipedia.org/wiki/Behavior-driven_development
[swordfish]: https://passwordfish.herokuapp.com
