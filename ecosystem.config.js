module.exports = {
  apps: [
    {
      name: 'java-app',
      script: '/usr/bin/java', // Path to the Java binary
      args: '-jar /Users/mukeshjha/Downloads/mycoolapp/target/mycoolapp-0.0.1-SNAPSHOT.jar server config.yml', // Arguments for the Java application
      interpreter: 'none', // No need for a specific shell
      exec_mode: 'fork', // 'fork' or 'cluster' mode
      instances: 1, // Number of instances to run
      autorestart: true, // Restart the app if it crashes
      watch: false, // Set to true to watch for file changes
      max_memory_restart: '1G' // Restart if memory usage exceeds 1GB
    }
  ]
};
