#!/bin/bash
set -e
docker pull adnrv/texlive
docker run --rm -it -v "$(pwd)":/home adnrv/texlive pdflatex main.tex
user=$(dirname $TRAVIS_REPO_SLUG)
curl -X  POST https://api.telegram.org/bot$TELEGRAM_TOKEN/sendMessage -d chat_id=$TELEGRAM_CHAT_ID -d "text= Commit: $TRAVIS_COMMIT_MESSAGE %0ATag: $TRAVIS_TAG %0ALink: https://github.com/Unibo-PPS-1920/pps1920-motoScala-report/releases/latest/download/main.pdf"