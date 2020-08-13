#!/bin/bash
set -e
if [ "$TRAVIS_EVENT_TYPE" = "push" ]; then
	if [ -z "$TRAVIS_TAG" ]; then
		curl -X  POST https://api.telegram.org/bot$TELEGRAM_TOKEN/sendMessage -d chat_id=$TELEGRAM_CHAT_ID -d "text= Commit:$TRAVIS_COMMIT_MESSAGE %0A Tag:$TRAVIS_TAG %0A https://github.com/Unibo-PPS-1920/pps1920-motoScala-report/releases/latest/download/main.pdf"
	else
		user=$(dirname $TRAVIS_REPO_SLUG)
		curl -X  POST https://api.telegram.org/bot$TELEGRAM_TOKEN/sendMessage -d chat_id=$TELEGRAM_CHAT_ID -d "text=$user pushed to $TRAVIS_BRANCH %0ACommit:$TRAVIS_COMMIT_MESSAGE%0Ahttps://github.com/Unibo-PPS-1920/pps1920-motoScala-report/commits/$TRAVIS_BRANCH"
	fi
fi