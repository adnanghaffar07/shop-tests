const Promise = require(`bluebird`);

/**
 * Retry all the lines again.
 */
exports.retry = function (performActions, timeoutMs, intervalTimeoutMs) {
  const endTime = Date.now() + (timeoutMs || 20000);
  const tryAgain = doReject => new Promise((resolve, reject) => {
    if (Date.now() >= endTime) {
      reject(doReject);
    } else {
      setTimeout(() => performActions()
        .then(function (...arguments) {
          resolve.apply(this, arguments);
        })
        .catch(function (...arguments) {
          resolve(tryAgain.apply(this, arguments));
        }), intervalTimeoutMs || 1000);
    }
  });
  return performActions().catch(tryAgain);
};
