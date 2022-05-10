module.exports = {
    'default': 'test_feature/features/ --require test_feature/ --publish-quiet',
    dry: '--dry-run',
    summary: '--format summary',
    progress: '--format progress',
    html_report: '--format json:reports/cucumber_report.json',
    parallel: '--parallel 2'
}
