import react from '@vitejs/plugin-react'
import {defineConfig} from 'vite'

export default defineConfig({
  plugins: [react()],
  server: {
    host: '0.0.0.0',  // Listen on all network interfaces
    port: 5173,
    open: true,  // Open the browser on server start
    proxy: {
      '/api': {
        target: process.env.PROXY_TARGET || 'http://localhost:8080',
        changeOrigin: true,
      }
    }
  }
})